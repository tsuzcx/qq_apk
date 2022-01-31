package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int tuv = 0;
  
  public static byte[] B(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(4355);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.Hb(8);
    paramInputStream.Hb(8);
    paramInputStream.Hb(8);
    paramInputStream.Hb(8);
    paramInputStream.Hb(8);
    int i = (int)paramInputStream.cLO();
    paramInputStream.Hb(8);
    paramInputStream.cLO();
    paramInputStream.cLS();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.cLR() == 3) {
        paramInputStream.Hb(1);
      }
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.Hb(1);
      if (paramInputStream.mL(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.mL(true))
          {
            if (i >= 6) {
              break label173;
            }
            paramInputStream.Hc(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label173:
            paramInputStream.Hc(64);
          }
        }
      }
    }
    paramInputStream.cLS();
    i = paramInputStream.cLR();
    if (i == 0)
    {
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.Hb(1);
      paramInputStream.cLS();
      paramInputStream.cLS();
      if (!paramInputStream.mL(true)) {
        paramInputStream.Hb(1);
      }
      paramInputStream.Hb(1);
      if (paramInputStream.mL(true))
      {
        paramInputStream.cLS();
        paramInputStream.cLS();
        paramInputStream.cLS();
        paramInputStream.cLS();
      }
      if (!paramInputStream.mL(false)) {
        break label732;
      }
      ab.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.mN(true);
      if ((paramInputStream.mL(true)) && ((int)paramInputStream.cLO() == 255))
      {
        paramInputStream.Hb(16);
        paramInputStream.Hb(16);
      }
      if (paramInputStream.mL(true)) {
        paramInputStream.Hb(1);
      }
      if (paramInputStream.mL(true))
      {
        paramInputStream.Hb(3);
        paramInputStream.Hb(1);
        if (paramInputStream.mL(true))
        {
          paramInputStream.Hb(8);
          paramInputStream.Hb(8);
          paramInputStream.Hb(8);
        }
      }
      if (paramInputStream.mL(true))
      {
        paramInputStream.cLS();
        paramInputStream.cLS();
      }
      if (paramInputStream.mL(true))
      {
        paramInputStream.Hb(32);
        paramInputStream.Hb(32);
        paramInputStream.Hb(1);
      }
      boolean bool1 = paramInputStream.mL(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.mL(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.Hb(1);
      }
      paramInputStream.Hb(1);
      if (!paramInputStream.mL(false)) {
        break label680;
      }
      ab.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.mN(true);
      paramInputStream.mL(true);
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.Hf(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.Hd(1);
      paramInputStream.I(0L, 8 - paramInputStream.tuE);
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
      paramInputStream.Hb(1);
      paramInputStream.cLS();
      paramInputStream.cLS();
      int k = paramInputStream.cLR();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.cLS();
        i += 1;
      }
      break;
      label680:
      ab.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.mN(true);
      paramInputStream.mN(true);
      paramInputStream.Hf(0);
      paramInputStream.Hf(0);
      paramInputStream.Hf(10);
      paramInputStream.Hf(10);
      paramInputStream.Hf(0);
      paramInputStream.Hf(1);
      continue;
      label732:
      ab.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.mN(true);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(false);
      paramInputStream.mN(true);
      paramInputStream.mN(true);
      paramInputStream.Hf(0);
      paramInputStream.Hf(0);
      paramInputStream.Hf(10);
      paramInputStream.Hf(10);
      paramInputStream.Hf(0);
      paramInputStream.Hf(1);
    }
    ab.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(4355);
    return arrayOfByte;
  }
  
  private boolean C(InputStream paramInputStream)
  {
    AppMethodBeat.i(4356);
    paramInputStream = new j(paramInputStream);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    int i = (int)paramInputStream.cLO();
    if (i == 66)
    {
      this.tuv |= 0x1;
      AppMethodBeat.o(4356);
      return false;
    }
    paramInputStream.Ha(8);
    paramInputStream.cLO();
    paramInputStream.cLQ();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.cLR() == 3) {
        paramInputStream.Ha(1);
      }
      paramInputStream.cLQ();
      paramInputStream.cLQ();
      paramInputStream.Ha(1);
      if (paramInputStream.mL(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.mL(true))
          {
            if (i >= 6) {
              break label184;
            }
            paramInputStream.Hc(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label184:
            paramInputStream.Hc(64);
          }
        }
      }
    }
    paramInputStream.cLQ();
    i = paramInputStream.cLR();
    if (i == 0) {
      paramInputStream.cLQ();
    }
    for (;;)
    {
      if (paramInputStream.cLR() >= 2) {
        this.tuv |= 0x2;
      }
      paramInputStream.Hb(1);
      paramInputStream.cLS();
      paramInputStream.cLS();
      if (!paramInputStream.mL(true)) {
        paramInputStream.Hb(1);
      }
      paramInputStream.Hb(1);
      if (paramInputStream.mL(true))
      {
        paramInputStream.cLS();
        paramInputStream.cLS();
        paramInputStream.cLS();
        paramInputStream.cLS();
      }
      if (!paramInputStream.mL(true)) {
        break;
      }
      ab.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.mL(true)) && ((int)paramInputStream.cLO() == 255))
      {
        paramInputStream.Hb(16);
        paramInputStream.Hb(16);
      }
      if (paramInputStream.mL(true)) {
        paramInputStream.Hb(1);
      }
      if (paramInputStream.mL(true))
      {
        paramInputStream.Hb(3);
        paramInputStream.Hb(1);
        if (paramInputStream.mL(true))
        {
          paramInputStream.Hb(8);
          paramInputStream.Hb(8);
          paramInputStream.Hb(8);
        }
      }
      if (paramInputStream.mL(true))
      {
        paramInputStream.cLS();
        paramInputStream.cLS();
      }
      if (paramInputStream.mL(true))
      {
        paramInputStream.Hb(32);
        paramInputStream.Hb(32);
        paramInputStream.Hb(1);
      }
      boolean bool1 = paramInputStream.mL(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.mL(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.Hb(1);
      }
      paramInputStream.Hb(1);
      if (!paramInputStream.mL(true)) {
        break;
      }
      paramInputStream.mL(true);
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.cLS();
      paramInputStream.cLS();
      i = paramInputStream.cLR();
      int j = paramInputStream.cLR();
      if (i == 0) {
        break;
      }
      ab.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.tuv |= 0x4;
      AppMethodBeat.o(4356);
      return true;
      if (i == 1)
      {
        paramInputStream.Ha(1);
        paramInputStream.cLQ();
        paramInputStream.cLQ();
        j = paramInputStream.cLR();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.cLS();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(4356);
    return false;
  }
  
  private boolean D(InputStream paramInputStream)
  {
    AppMethodBeat.i(140142);
    paramInputStream = new j(paramInputStream);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.Ha(8);
    paramInputStream.cLQ();
    int i = paramInputStream.cLR();
    ab.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.tuv |= 0x8;
      AppMethodBeat.o(140142);
      return true;
    }
    AppMethodBeat.o(140142);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(4357);
    int j = paramj.cLR();
    paramj.Ha(4);
    paramj.Ha(4);
    int i = 0;
    while (i <= j)
    {
      paramj.cLQ();
      paramj.cLQ();
      paramj.Ha(1);
      i += 1;
    }
    paramj.Ha(5);
    paramj.Ha(5);
    paramj.Ha(5);
    paramj.Ha(5);
    AppMethodBeat.o(4357);
  }
  
  public final boolean bp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140140);
    boolean bool = C(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(140140);
    return bool;
  }
  
  public final boolean bq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140141);
    boolean bool = D(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(140141);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */