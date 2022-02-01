package com.tencent.tbs.one.impl.e.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

public final class a
  extends com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<File>>
{
  Context b;
  String c;
  d.a d;
  File e;
  private Bundle f;
  
  public a(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = parama;
    this.e = paramFile;
    this.f = paramBundle;
  }
  
  public final void a()
  {
    AppMethodBeat.i(174068);
    m.d(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = null;
        int i = 0;
        AppMethodBeat.i(174070);
        a locala = a.this;
        Object localObject4 = a.this.b;
        Object localObject3 = a.this.d;
        File localFile1 = a.this.e;
        localObject4 = com.tencent.tbs.one.impl.common.f.a((Context)localObject4);
        String str1 = ((d.a)localObject3).a;
        localObject3 = com.tencent.tbs.one.impl.common.f.a((File)localObject4, str1, "MANIFEST");
        Object localObject5;
        int j;
        try
        {
          localObject5 = com.tencent.tbs.one.impl.common.e.a((File)localObject3);
          j = locala.d.c;
          int k = ((com.tencent.tbs.one.impl.common.e)localObject5).a;
          if (j != k)
          {
            locala.a(417, "Failed to verify version code, expected " + j + " but was " + k, null);
            AppMethodBeat.o(174070);
            return;
          }
        }
        catch (TBSOneException localTBSOneException1)
        {
          locala.a(localTBSOneException1.getErrorCode(), localTBSOneException1.getMessage(), localTBSOneException1.getCause());
          AppMethodBeat.o(174070);
          return;
        }
        if (!localFile1.mkdirs()) {
          com.tencent.tbs.one.impl.a.f.c("Failed to create directory %s", new Object[] { localFile1.getAbsolutePath() });
        }
        try
        {
          c.a((File)localObject3, new File(localFile1, "MANIFEST"));
          localObject5 = ((com.tencent.tbs.one.impl.common.e)localObject5).e;
          j = localObject5.length;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            try
            {
              c.a(com.tencent.tbs.one.impl.common.f.a((File)localObject4, str1, str2), localFile2);
              str2 = ((com.tencent.tbs.one.impl.common.e.a)localObject3).b;
              localObject3 = localTBSOneException1;
              if (!TextUtils.isEmpty(str2))
              {
                localObject3 = localTBSOneException1;
                if (localTBSOneException1 != null) {}
              }
            }
            catch (IOException localIOException2)
            {
              String str2;
              File localFile2;
              Object localObject2;
              locala.a(312, "Failed to copy builtin component file from " + ((File)localObject4).getAbsolutePath() + " to " + localFile2.getAbsolutePath(), localIOException2);
              AppMethodBeat.o(174070);
              return;
            }
            try
            {
              localObject3 = com.tencent.tbs.one.impl.e.f.a();
              com.tencent.tbs.one.impl.e.f.a((MessageDigest)localObject3, localFile2, str2);
              i += 1;
              localObject2 = localObject3;
            }
            catch (TBSOneException localTBSOneException2)
            {
              locala.a(localTBSOneException2.getErrorCode(), localTBSOneException2.getMessage(), localTBSOneException2.getCause());
              AppMethodBeat.o(174070);
              return;
            }
          }
          localIOException1 = localIOException1;
          locala.a(312, "Failed to copy builtin component file from " + ((File)localObject4).getAbsolutePath() + " to " + ((File)localObject3).getAbsolutePath(), localIOException1);
          AppMethodBeat.o(174070);
          return;
        }
        if (i < j)
        {
          localObject3 = localObject5[i];
          str2 = ((com.tencent.tbs.one.impl.common.e.a)localObject3).a;
          localFile2 = new File(localFile1, str2);
        }
        locala.a(com.tencent.tbs.one.impl.e.e.a(com.tencent.tbs.one.impl.e.e.a.b, localFile1));
        AppMethodBeat.o(174070);
      }
    });
    AppMethodBeat.o(174068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.b.a
 * JD-Core Version:    0.7.0.1
 */