package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class f
{
  public int pPq = 0;
  
  public static byte[] B(InputStream paramInputStream)
  {
    int j = 0;
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new i(paramInputStream, (OutputStream)localObject);
    paramInputStream.zS(8);
    paramInputStream.zS(8);
    paramInputStream.zS(8);
    paramInputStream.zS(8);
    paramInputStream.zS(8);
    int i = (int)paramInputStream.bPM();
    paramInputStream.zS(8);
    paramInputStream.bPM();
    paramInputStream.bPP();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.bPO() == 3) {
        paramInputStream.zS(1);
      }
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.zS(1);
      if (paramInputStream.jS(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.jS(true))
          {
            if (i >= 6) {
              break label167;
            }
            paramInputStream.zT(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label167:
            paramInputStream.zT(64);
          }
        }
      }
    }
    paramInputStream.bPP();
    i = paramInputStream.bPO();
    if (i == 0)
    {
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.zS(1);
      paramInputStream.bPP();
      paramInputStream.bPP();
      if (!paramInputStream.jS(true)) {
        paramInputStream.zS(1);
      }
      paramInputStream.zS(1);
      if (paramInputStream.jS(true))
      {
        paramInputStream.bPP();
        paramInputStream.bPP();
        paramInputStream.bPP();
        paramInputStream.bPP();
      }
      if (!paramInputStream.jS(false)) {
        break label733;
      }
      y.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.jU(true);
      if ((paramInputStream.jS(true)) && ((int)paramInputStream.bPM() == 255))
      {
        paramInputStream.zS(16);
        paramInputStream.zS(16);
      }
      if (paramInputStream.jS(true)) {
        paramInputStream.zS(1);
      }
      if (paramInputStream.jS(true))
      {
        paramInputStream.zS(3);
        paramInputStream.zS(1);
        if (paramInputStream.jS(true))
        {
          paramInputStream.zS(8);
          paramInputStream.zS(8);
          paramInputStream.zS(8);
        }
      }
      if (paramInputStream.jS(true))
      {
        paramInputStream.bPP();
        paramInputStream.bPP();
      }
      if (paramInputStream.jS(true))
      {
        paramInputStream.zS(32);
        paramInputStream.zS(32);
        paramInputStream.zS(1);
      }
      boolean bool1 = paramInputStream.jS(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.jS(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.zS(1);
      }
      paramInputStream.zS(1);
      if (!paramInputStream.jS(false)) {
        break label681;
      }
      y.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.jU(true);
      paramInputStream.jS(true);
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.zV(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.zU(1);
      paramInputStream.y(0L, 8 - paramInputStream.pPz);
      paramInputStream.flush();
      arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      paramInputStream = "";
      i = j;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = "0" + str;
        }
        paramInputStream = paramInputStream + " " + (String)localObject;
        i += 1;
      }
      if (i != 1) {
        break;
      }
      paramInputStream.zS(1);
      paramInputStream.bPP();
      paramInputStream.bPP();
      int k = paramInputStream.bPO();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.bPP();
        i += 1;
      }
      break;
      label681:
      y.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.jU(true);
      paramInputStream.jU(true);
      paramInputStream.zV(0);
      paramInputStream.zV(0);
      paramInputStream.zV(10);
      paramInputStream.zV(10);
      paramInputStream.zV(0);
      paramInputStream.zV(1);
      continue;
      label733:
      y.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.jU(true);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(false);
      paramInputStream.jU(true);
      paramInputStream.jU(true);
      paramInputStream.zV(0);
      paramInputStream.zV(0);
      paramInputStream.zV(10);
      paramInputStream.zV(10);
      paramInputStream.zV(0);
      paramInputStream.zV(1);
    }
    y.d("TAG", "new SPS:" + paramInputStream);
    return arrayOfByte;
  }
  
  private static void a(i parami)
  {
    int j = parami.bPO();
    parami.zR(4);
    parami.zR(4);
    int i = 0;
    while (i <= j)
    {
      parami.bPP();
      parami.bPP();
      parami.zR(1);
      i += 1;
    }
    parami.zR(5);
    parami.zR(5);
    parami.zR(5);
    parami.zR(5);
  }
  
  public final boolean C(InputStream paramInputStream)
  {
    paramInputStream = new i(paramInputStream);
    paramInputStream.zR(8);
    paramInputStream.zR(8);
    paramInputStream.zR(8);
    paramInputStream.zR(8);
    paramInputStream.zR(8);
    int i = (int)paramInputStream.bPM();
    if (i == 66)
    {
      this.pPq |= 0x1;
      return false;
    }
    paramInputStream.zR(8);
    paramInputStream.bPM();
    paramInputStream.bPP();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.bPO() == 3) {
        paramInputStream.zR(1);
      }
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.zR(1);
      if (paramInputStream.jS(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.jS(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.zT(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.zT(64);
          }
        }
      }
    }
    paramInputStream.bPP();
    i = paramInputStream.bPO();
    if (i == 0) {
      paramInputStream.bPP();
    }
    for (;;)
    {
      if (paramInputStream.bPO() >= 2) {
        this.pPq |= 0x2;
      }
      paramInputStream.zS(1);
      paramInputStream.bPP();
      paramInputStream.bPP();
      if (!paramInputStream.jS(true)) {
        paramInputStream.zS(1);
      }
      paramInputStream.zS(1);
      if (paramInputStream.jS(true))
      {
        paramInputStream.bPP();
        paramInputStream.bPP();
        paramInputStream.bPP();
        paramInputStream.bPP();
      }
      if (!paramInputStream.jS(true)) {
        break;
      }
      y.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.jS(true)) && ((int)paramInputStream.bPM() == 255))
      {
        paramInputStream.zS(16);
        paramInputStream.zS(16);
      }
      if (paramInputStream.jS(true)) {
        paramInputStream.zS(1);
      }
      if (paramInputStream.jS(true))
      {
        paramInputStream.zS(3);
        paramInputStream.zS(1);
        if (paramInputStream.jS(true))
        {
          paramInputStream.zS(8);
          paramInputStream.zS(8);
          paramInputStream.zS(8);
        }
      }
      if (paramInputStream.jS(true))
      {
        paramInputStream.bPP();
        paramInputStream.bPP();
      }
      if (paramInputStream.jS(true))
      {
        paramInputStream.zS(32);
        paramInputStream.zS(32);
        paramInputStream.zS(1);
      }
      boolean bool1 = paramInputStream.jS(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.jS(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.zS(1);
      }
      paramInputStream.zS(1);
      if (!paramInputStream.jS(true)) {
        break;
      }
      paramInputStream.jS(true);
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.bPP();
      paramInputStream.bPP();
      i = paramInputStream.bPO();
      int j = paramInputStream.bPO();
      if (i == 0) {
        break;
      }
      y.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.pPq |= 0x4;
      return true;
      if (i == 1)
      {
        paramInputStream.zR(1);
        paramInputStream.bPP();
        paramInputStream.bPP();
        j = paramInputStream.bPO();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.bPP();
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.f
 * JD-Core Version:    0.7.0.1
 */