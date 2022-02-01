package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int UwP = 0;
  
  private static byte[] W(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.apY(8);
    paramInputStream.apY(8);
    paramInputStream.apY(8);
    paramInputStream.apY(8);
    paramInputStream.apY(8);
    int i = (int)paramInputStream.hWo();
    paramInputStream.apY(8);
    paramInputStream.hWo();
    paramInputStream.hWs();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.hWr() == 3) {
        paramInputStream.apY(1);
      }
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.apY(1);
      if (paramInputStream.Go(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.Go(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.apZ(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.apZ(64);
          }
        }
      }
    }
    paramInputStream.hWs();
    i = paramInputStream.hWr();
    if (i == 0)
    {
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.apY(1);
      paramInputStream.hWs();
      paramInputStream.hWs();
      if (!paramInputStream.Go(true)) {
        paramInputStream.apY(1);
      }
      paramInputStream.apY(1);
      if (paramInputStream.Go(true))
      {
        paramInputStream.hWs();
        paramInputStream.hWs();
        paramInputStream.hWs();
        paramInputStream.hWs();
      }
      if (!paramInputStream.Go(false)) {
        break label731;
      }
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.Gq(true);
      if ((paramInputStream.Go(true)) && ((int)paramInputStream.hWo() == 255))
      {
        paramInputStream.apY(16);
        paramInputStream.apY(16);
      }
      if (paramInputStream.Go(true)) {
        paramInputStream.apY(1);
      }
      if (paramInputStream.Go(true))
      {
        paramInputStream.apY(3);
        paramInputStream.apY(1);
        if (paramInputStream.Go(true))
        {
          paramInputStream.apY(8);
          paramInputStream.apY(8);
          paramInputStream.apY(8);
        }
      }
      if (paramInputStream.Go(true))
      {
        paramInputStream.hWs();
        paramInputStream.hWs();
      }
      if (paramInputStream.Go(true))
      {
        paramInputStream.apY(32);
        paramInputStream.apY(32);
        paramInputStream.apY(1);
      }
      boolean bool1 = paramInputStream.Go(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.Go(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.apY(1);
      }
      paramInputStream.apY(1);
      if (!paramInputStream.Go(false)) {
        break label679;
      }
      Log.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.Gq(true);
      paramInputStream.Go(true);
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.aqc(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.aqa(1);
      paramInputStream.aI(0L, 8 - paramInputStream.Uyo);
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
      paramInputStream.apY(1);
      paramInputStream.hWs();
      paramInputStream.hWs();
      int k = paramInputStream.hWr();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.hWs();
        i += 1;
      }
      break;
      label679:
      Log.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.Gq(true);
      paramInputStream.Gq(true);
      paramInputStream.aqc(0);
      paramInputStream.aqc(0);
      paramInputStream.aqc(10);
      paramInputStream.aqc(10);
      paramInputStream.aqc(0);
      paramInputStream.aqc(1);
      continue;
      label731:
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.Gq(true);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(false);
      paramInputStream.Gq(true);
      paramInputStream.Gq(true);
      paramInputStream.aqc(0);
      paramInputStream.aqc(0);
      paramInputStream.aqc(10);
      paramInputStream.aqc(10);
      paramInputStream.aqc(0);
      paramInputStream.aqc(1);
    }
    Log.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean X(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    int i = (int)paramInputStream.hWo();
    if (i == 66)
    {
      this.UwP |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.apX(8);
    paramInputStream.hWo();
    paramInputStream.hWq();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.hWr() == 3) {
        paramInputStream.apX(1);
      }
      paramInputStream.hWq();
      paramInputStream.hWq();
      paramInputStream.apX(1);
      if (paramInputStream.Go(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.Go(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.apZ(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.apZ(64);
          }
        }
      }
    }
    paramInputStream.hWq();
    i = paramInputStream.hWr();
    if (i == 0) {
      paramInputStream.hWq();
    }
    for (;;)
    {
      if (paramInputStream.hWr() >= 2) {
        this.UwP |= 0x2;
      }
      paramInputStream.apY(1);
      paramInputStream.hWs();
      paramInputStream.hWs();
      if (!paramInputStream.Go(true)) {
        paramInputStream.apY(1);
      }
      paramInputStream.apY(1);
      if (paramInputStream.Go(true))
      {
        paramInputStream.hWs();
        paramInputStream.hWs();
        paramInputStream.hWs();
        paramInputStream.hWs();
      }
      if (!paramInputStream.Go(true)) {
        break;
      }
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.Go(true)) && ((int)paramInputStream.hWo() == 255))
      {
        paramInputStream.apY(16);
        paramInputStream.apY(16);
      }
      if (paramInputStream.Go(true)) {
        paramInputStream.apY(1);
      }
      if (paramInputStream.Go(true))
      {
        paramInputStream.apY(3);
        paramInputStream.apY(1);
        if (paramInputStream.Go(true))
        {
          paramInputStream.apY(8);
          paramInputStream.apY(8);
          paramInputStream.apY(8);
        }
      }
      if (paramInputStream.Go(true))
      {
        paramInputStream.hWs();
        paramInputStream.hWs();
      }
      if (paramInputStream.Go(true))
      {
        paramInputStream.apY(32);
        paramInputStream.apY(32);
        paramInputStream.apY(1);
      }
      boolean bool1 = paramInputStream.Go(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.Go(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.apY(1);
      }
      paramInputStream.apY(1);
      if (!paramInputStream.Go(true)) {
        break;
      }
      paramInputStream.Go(true);
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.hWs();
      paramInputStream.hWs();
      i = paramInputStream.hWr();
      int j = paramInputStream.hWr();
      if (i == 0) {
        break;
      }
      Log.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.UwP |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.apX(1);
        paramInputStream.hWq();
        paramInputStream.hWq();
        j = paramInputStream.hWr();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.hWs();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean Y(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.apX(8);
    paramInputStream.hWq();
    int i = paramInputStream.hWr();
    Log.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.UwP |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.hWr();
    paramj.apX(4);
    paramj.apX(4);
    int i = 0;
    while (i <= j)
    {
      paramj.hWq();
      paramj.hWq();
      paramj.apX(1);
      i += 1;
    }
    paramj.apX(5);
    paramj.apX(5);
    paramj.apX(5);
    paramj.apX(5);
    AppMethodBeat.o(114852);
  }
  
  public final boolean cA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = X(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = Y(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
  
  public final byte[] cz(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(293293);
    paramArrayOfByte = W(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(293293);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */