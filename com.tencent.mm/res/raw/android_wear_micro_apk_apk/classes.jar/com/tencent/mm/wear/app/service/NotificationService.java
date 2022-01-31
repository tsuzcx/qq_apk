package com.tencent.mm.wear.app.service;

import android.content.Intent;
import com.tencent.mm.e.a.x;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.e;
import com.tencent.mm.wear.app.g.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class NotificationService
  extends BaseNotificationService
{
  protected final void a(Intent paramIntent, int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = false;
    Object localObject = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      bool = true;
      paramIntent = localObject;
      for (;;)
      {
        paramIntent = new e(paramInt1, paramInt2, paramIntent);
        paramIntent.G(bool);
        h.mc().a(paramIntent);
        return;
        int i = paramIntent.getIntExtra("key_unread_count", 0);
        paramIntent = new x();
        paramIntent.VN = paramString;
        paramIntent.We = i;
        try
        {
          paramIntent = paramIntent.toByteArray();
        }
        catch (IOException paramIntent)
        {
          try
          {
            paramIntent = paramString.getBytes("utf8");
            bool = true;
          }
          catch (UnsupportedEncodingException paramIntent) {}
          paramIntent = paramIntent;
          paramIntent = localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.NotificationService
 * JD-Core Version:    0.7.0.1
 */