package org.xwalk.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XWalkUpdater$PatchFileConfigParser
{
  private static final String ADD_FLAG = "ADD:";
  private static final int ADD_TYPE = 1;
  private static final int APK_FILE_TYPE = 1;
  private static final String DEL_FLAG = "DEL:";
  private static final int DEL_TYPE = 3;
  private static final int EXTRACTED_FILE_TYPE = 2;
  private static final String MOD_FLAG = "MOD:";
  private static final int MOD_TYPE = 2;
  private static final String PATCH_SUFFIX = ".patch";
  
  public static ArrayList<XWalkUpdater.PatchFileConfig> getPatchFileConfigList(int paramInt)
  {
    for (;;)
    {
      InputStreamReader localInputStreamReader;
      BufferedReader localBufferedReader;
      ArrayList localArrayList;
      int i;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(new File(XWalkEnvironment.getPatchConfig(paramInt)));
        localInputStreamReader = new InputStreamReader(localFileInputStream);
        localBufferedReader = new BufferedReader(localInputStreamReader);
        localArrayList = new ArrayList();
        Object localObject1 = localBufferedReader.readLine();
        if (localObject1 != null)
        {
          if ((localObject1 == null) || (((String)localObject1).isEmpty())) {
            continue;
          }
          XWalkUpdater.PatchFileConfig localPatchFileConfig;
          if (((String)localObject1).startsWith("ADD:"))
          {
            localObject1 = ((String)localObject1).substring(4);
            paramInt = 1;
            localObject1 = ((String)localObject1).split(",");
            int j = localObject1.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = localObject1[i];
            if ((localObject2 == null) || (localObject2.isEmpty())) {
              break label338;
            }
            localPatchFileConfig = new XWalkUpdater.PatchFileConfig();
            localPatchFileConfig.originalFileName = localObject2;
            localPatchFileConfig.type = paramInt;
            if (paramInt == 2) {
              localPatchFileConfig.patchFileName = (localPatchFileConfig.originalFileName + ".patch");
            }
            if ((paramInt == 2) && (localPatchFileConfig.originalFileName.equals("base.apk")))
            {
              localPatchFileConfig.originalFileType = 1;
              Log.d("XWalkLib", "getPatchFileConfigList config:" + localPatchFileConfig.toString());
              localArrayList.add(localPatchFileConfig);
              break label338;
            }
          }
          else
          {
            if (((String)localObject1).startsWith("MOD:"))
            {
              localObject1 = ((String)localObject1).substring(4);
              paramInt = 2;
              continue;
            }
            if (!((String)localObject1).startsWith("DEL:")) {
              break label333;
            }
            localObject1 = ((String)localObject1).substring(4);
            paramInt = 3;
            continue;
          }
          localPatchFileConfig.originalFileType = 2;
          continue;
        }
        localFileInputStream.close();
      }
      catch (Exception localException)
      {
        Log.e("XWalkLib", "getPatchFileConfigList error:" + localException.getMessage());
        return null;
      }
      localInputStreamReader.close();
      localBufferedReader.close();
      return localArrayList;
      label333:
      paramInt = 0;
      continue;
      label338:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.PatchFileConfigParser
 * JD-Core Version:    0.7.0.1
 */