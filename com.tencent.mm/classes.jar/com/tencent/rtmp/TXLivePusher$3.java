package com.tencent.rtmp;

import com.tencent.liteav.basic.util.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class TXLivePusher$3
  implements Runnable
{
  TXLivePusher$3(TXLivePusher paramTXLivePusher, String paramString) {}
  
  public void run()
  {
    Object localObject = new File(this.val$videoFilePath).getParentFile();
    String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
    localObject = localObject + File.separator + String.format("TXUGCCover_%s.jpg", new Object[] { str });
    a.a(this.val$videoFilePath, (String)localObject);
    TXLivePusher.access$400(this.this$0, this.val$videoFilePath, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.3
 * JD-Core Version:    0.7.0.1
 */