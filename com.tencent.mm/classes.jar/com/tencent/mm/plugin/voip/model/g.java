package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int zgM = 0;
  
  public static byte[] K(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.PU(8);
    paramInputStream.PU(8);
    paramInputStream.PU(8);
    paramInputStream.PU(8);
    paramInputStream.PU(8);
    int i = (int)paramInputStream.dSM();
    paramInputStream.PU(8);
    paramInputStream.dSM();
    paramInputStream.dSQ();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.dSP() == 3) {
        paramInputStream.PU(1);
      }
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.PU(1);
      if (paramInputStream.rw(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.rw(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.PV(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.PV(64);
          }
        }
      }
    }
    paramInputStream.dSQ();
    i = paramInputStream.dSP();
    if (i == 0)
    {
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.PU(1);
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      if (!paramInputStream.rw(true)) {
        paramInputStream.PU(1);
      }
      paramInputStream.PU(1);
      if (paramInputStream.rw(true))
      {
        paramInputStream.dSQ();
        paramInputStream.dSQ();
        paramInputStream.dSQ();
        paramInputStream.dSQ();
      }
      if (!paramInputStream.rw(false)) {
        break label731;
      }
      ad.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.ry(true);
      if ((paramInputStream.rw(true)) && ((int)paramInputStream.dSM() == 255))
      {
        paramInputStream.PU(16);
        paramInputStream.PU(16);
      }
      if (paramInputStream.rw(true)) {
        paramInputStream.PU(1);
      }
      if (paramInputStream.rw(true))
      {
        paramInputStream.PU(3);
        paramInputStream.PU(1);
        if (paramInputStream.rw(true))
        {
          paramInputStream.PU(8);
          paramInputStream.PU(8);
          paramInputStream.PU(8);
        }
      }
      if (paramInputStream.rw(true))
      {
        paramInputStream.dSQ();
        paramInputStream.dSQ();
      }
      if (paramInputStream.rw(true))
      {
        paramInputStream.PU(32);
        paramInputStream.PU(32);
        paramInputStream.PU(1);
      }
      boolean bool1 = paramInputStream.rw(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.rw(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.PU(1);
      }
      paramInputStream.PU(1);
      if (!paramInputStream.rw(false)) {
        break label679;
      }
      ad.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.ry(true);
      paramInputStream.rw(true);
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.PY(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.PW(1);
      paramInputStream.X(0L, 8 - paramInputStream.zit);
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
      paramInputStream.PU(1);
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      int k = paramInputStream.dSP();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.dSQ();
        i += 1;
      }
      break;
      label679:
      ad.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.ry(true);
      paramInputStream.ry(true);
      paramInputStream.PY(0);
      paramInputStream.PY(0);
      paramInputStream.PY(10);
      paramInputStream.PY(10);
      paramInputStream.PY(0);
      paramInputStream.PY(1);
      continue;
      label731:
      ad.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.ry(true);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(false);
      paramInputStream.ry(true);
      paramInputStream.ry(true);
      paramInputStream.PY(0);
      paramInputStream.PY(0);
      paramInputStream.PY(10);
      paramInputStream.PY(10);
      paramInputStream.PY(0);
      paramInputStream.PY(1);
    }
    ad.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean L(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    int i = (int)paramInputStream.dSM();
    if (i == 66)
    {
      this.zgM |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.PT(8);
    paramInputStream.dSM();
    paramInputStream.dSO();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.dSP() == 3) {
        paramInputStream.PT(1);
      }
      paramInputStream.dSO();
      paramInputStream.dSO();
      paramInputStream.PT(1);
      if (paramInputStream.rw(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.rw(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.PV(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.PV(64);
          }
        }
      }
    }
    paramInputStream.dSO();
    i = paramInputStream.dSP();
    if (i == 0) {
      paramInputStream.dSO();
    }
    for (;;)
    {
      if (paramInputStream.dSP() >= 2) {
        this.zgM |= 0x2;
      }
      paramInputStream.PU(1);
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      if (!paramInputStream.rw(true)) {
        paramInputStream.PU(1);
      }
      paramInputStream.PU(1);
      if (paramInputStream.rw(true))
      {
        paramInputStream.dSQ();
        paramInputStream.dSQ();
        paramInputStream.dSQ();
        paramInputStream.dSQ();
      }
      if (!paramInputStream.rw(true)) {
        break;
      }
      ad.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.rw(true)) && ((int)paramInputStream.dSM() == 255))
      {
        paramInputStream.PU(16);
        paramInputStream.PU(16);
      }
      if (paramInputStream.rw(true)) {
        paramInputStream.PU(1);
      }
      if (paramInputStream.rw(true))
      {
        paramInputStream.PU(3);
        paramInputStream.PU(1);
        if (paramInputStream.rw(true))
        {
          paramInputStream.PU(8);
          paramInputStream.PU(8);
          paramInputStream.PU(8);
        }
      }
      if (paramInputStream.rw(true))
      {
        paramInputStream.dSQ();
        paramInputStream.dSQ();
      }
      if (paramInputStream.rw(true))
      {
        paramInputStream.PU(32);
        paramInputStream.PU(32);
        paramInputStream.PU(1);
      }
      boolean bool1 = paramInputStream.rw(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.rw(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.PU(1);
      }
      paramInputStream.PU(1);
      if (!paramInputStream.rw(true)) {
        break;
      }
      paramInputStream.rw(true);
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      paramInputStream.dSQ();
      i = paramInputStream.dSP();
      int j = paramInputStream.dSP();
      if (i == 0) {
        break;
      }
      ad.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.zgM |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.PT(1);
        paramInputStream.dSO();
        paramInputStream.dSO();
        j = paramInputStream.dSP();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.dSQ();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean M(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.PT(8);
    paramInputStream.dSO();
    int i = paramInputStream.dSP();
    ad.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.zgM |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.dSP();
    paramj.PT(4);
    paramj.PT(4);
    int i = 0;
    while (i <= j)
    {
      paramj.dSO();
      paramj.dSO();
      paramj.PT(1);
      i += 1;
    }
    paramj.PT(5);
    paramj.PT(5);
    paramj.PT(5);
    paramj.PT(5);
    AppMethodBeat.o(114852);
  }
  
  public final boolean bH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = L(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = M(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */