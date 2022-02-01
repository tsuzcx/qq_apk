package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int BYv = 0;
  
  private static byte[] M(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.TV(8);
    paramInputStream.TV(8);
    paramInputStream.TV(8);
    paramInputStream.TV(8);
    paramInputStream.TV(8);
    int i = (int)paramInputStream.evJ();
    paramInputStream.TV(8);
    paramInputStream.evJ();
    paramInputStream.evN();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.evM() == 3) {
        paramInputStream.TV(1);
      }
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.TV(1);
      if (paramInputStream.tg(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.tg(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.TW(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.TW(64);
          }
        }
      }
    }
    paramInputStream.evN();
    i = paramInputStream.evM();
    if (i == 0)
    {
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.TV(1);
      paramInputStream.evN();
      paramInputStream.evN();
      if (!paramInputStream.tg(true)) {
        paramInputStream.TV(1);
      }
      paramInputStream.TV(1);
      if (paramInputStream.tg(true))
      {
        paramInputStream.evN();
        paramInputStream.evN();
        paramInputStream.evN();
        paramInputStream.evN();
      }
      if (!paramInputStream.tg(false)) {
        break label731;
      }
      ad.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.ti(true);
      if ((paramInputStream.tg(true)) && ((int)paramInputStream.evJ() == 255))
      {
        paramInputStream.TV(16);
        paramInputStream.TV(16);
      }
      if (paramInputStream.tg(true)) {
        paramInputStream.TV(1);
      }
      if (paramInputStream.tg(true))
      {
        paramInputStream.TV(3);
        paramInputStream.TV(1);
        if (paramInputStream.tg(true))
        {
          paramInputStream.TV(8);
          paramInputStream.TV(8);
          paramInputStream.TV(8);
        }
      }
      if (paramInputStream.tg(true))
      {
        paramInputStream.evN();
        paramInputStream.evN();
      }
      if (paramInputStream.tg(true))
      {
        paramInputStream.TV(32);
        paramInputStream.TV(32);
        paramInputStream.TV(1);
      }
      boolean bool1 = paramInputStream.tg(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.tg(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.TV(1);
      }
      paramInputStream.TV(1);
      if (!paramInputStream.tg(false)) {
        break label679;
      }
      ad.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.ti(true);
      paramInputStream.tg(true);
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.TZ(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.TX(1);
      paramInputStream.af(0L, 8 - paramInputStream.Cac);
      paramInputStream.flush();
      arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      paramInputStream = "";
      i = j;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = "0".concat(String.valueOf(str));
        }
        paramInputStream = paramInputStream + " " + (String)localObject;
        i += 1;
      }
      if (i != 1) {
        break;
      }
      paramInputStream.TV(1);
      paramInputStream.evN();
      paramInputStream.evN();
      int k = paramInputStream.evM();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.evN();
        i += 1;
      }
      break;
      label679:
      ad.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.ti(true);
      paramInputStream.ti(true);
      paramInputStream.TZ(0);
      paramInputStream.TZ(0);
      paramInputStream.TZ(10);
      paramInputStream.TZ(10);
      paramInputStream.TZ(0);
      paramInputStream.TZ(1);
      continue;
      label731:
      ad.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.ti(true);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(false);
      paramInputStream.ti(true);
      paramInputStream.ti(true);
      paramInputStream.TZ(0);
      paramInputStream.TZ(0);
      paramInputStream.TZ(10);
      paramInputStream.TZ(10);
      paramInputStream.TZ(0);
      paramInputStream.TZ(1);
    }
    ad.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean N(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    int i = (int)paramInputStream.evJ();
    if (i == 66)
    {
      this.BYv |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.TU(8);
    paramInputStream.evJ();
    paramInputStream.evL();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.evM() == 3) {
        paramInputStream.TU(1);
      }
      paramInputStream.evL();
      paramInputStream.evL();
      paramInputStream.TU(1);
      if (paramInputStream.tg(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.tg(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.TW(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.TW(64);
          }
        }
      }
    }
    paramInputStream.evL();
    i = paramInputStream.evM();
    if (i == 0) {
      paramInputStream.evL();
    }
    for (;;)
    {
      if (paramInputStream.evM() >= 2) {
        this.BYv |= 0x2;
      }
      paramInputStream.TV(1);
      paramInputStream.evN();
      paramInputStream.evN();
      if (!paramInputStream.tg(true)) {
        paramInputStream.TV(1);
      }
      paramInputStream.TV(1);
      if (paramInputStream.tg(true))
      {
        paramInputStream.evN();
        paramInputStream.evN();
        paramInputStream.evN();
        paramInputStream.evN();
      }
      if (!paramInputStream.tg(true)) {
        break;
      }
      ad.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.tg(true)) && ((int)paramInputStream.evJ() == 255))
      {
        paramInputStream.TV(16);
        paramInputStream.TV(16);
      }
      if (paramInputStream.tg(true)) {
        paramInputStream.TV(1);
      }
      if (paramInputStream.tg(true))
      {
        paramInputStream.TV(3);
        paramInputStream.TV(1);
        if (paramInputStream.tg(true))
        {
          paramInputStream.TV(8);
          paramInputStream.TV(8);
          paramInputStream.TV(8);
        }
      }
      if (paramInputStream.tg(true))
      {
        paramInputStream.evN();
        paramInputStream.evN();
      }
      if (paramInputStream.tg(true))
      {
        paramInputStream.TV(32);
        paramInputStream.TV(32);
        paramInputStream.TV(1);
      }
      boolean bool1 = paramInputStream.tg(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.tg(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.TV(1);
      }
      paramInputStream.TV(1);
      if (!paramInputStream.tg(true)) {
        break;
      }
      paramInputStream.tg(true);
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.evN();
      paramInputStream.evN();
      i = paramInputStream.evM();
      int j = paramInputStream.evM();
      if (i == 0) {
        break;
      }
      ad.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.BYv |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.TU(1);
        paramInputStream.evL();
        paramInputStream.evL();
        j = paramInputStream.evM();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.evN();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean O(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.TU(8);
    paramInputStream.evL();
    int i = paramInputStream.evM();
    ad.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.BYv |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.evM();
    paramj.TU(4);
    paramj.TU(4);
    int i = 0;
    while (i <= j)
    {
      paramj.evL();
      paramj.evL();
      paramj.TU(1);
      i += 1;
    }
    paramj.TU(5);
    paramj.TU(5);
    paramj.TU(5);
    paramj.TU(5);
    AppMethodBeat.o(114852);
  }
  
  public static byte[] bM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216242);
    paramArrayOfByte = M(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(216242);
    return paramArrayOfByte;
  }
  
  public final boolean bN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = N(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean bO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = O(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */