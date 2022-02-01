package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class dch
  extends com.tencent.mm.bx.a
{
  public String ASo;
  public String EtM;
  public String EtN;
  public String md5;
  public int nee = -1;
  public int reportId;
  public int version;
  public long wLF;
  public String yaG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193014);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ASo == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.EtM == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.yaG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.EtN == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.nee);
      paramVarArgs.aR(2, this.version);
      if (this.ASo != null) {
        paramVarArgs.d(3, this.ASo);
      }
      if (this.EtM != null) {
        paramVarArgs.d(4, this.EtM);
      }
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      if (this.yaG != null) {
        paramVarArgs.d(6, this.yaG);
      }
      if (this.EtN != null) {
        paramVarArgs.d(7, this.EtN);
      }
      paramVarArgs.aG(8, this.wLF);
      paramVarArgs.aR(9, this.reportId);
      AppMethodBeat.o(193014);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.nee) + 0 + f.a.a.b.b.a.bA(2, this.version);
      paramInt = i;
      if (this.ASo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ASo);
      }
      i = paramInt;
      if (this.EtM != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EtM);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt;
      if (this.yaG != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yaG);
      }
      paramInt = i;
      if (this.EtN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EtN);
      }
      i = f.a.a.b.b.a.q(8, this.wLF);
      int j = f.a.a.b.b.a.bA(9, this.reportId);
      AppMethodBeat.o(193014);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.ASo == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.EtM == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.yaG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      if (this.EtN == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(193014);
        throw paramVarArgs;
      }
      AppMethodBeat.o(193014);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dch localdch = (dch)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(193014);
        return -1;
      case 1: 
        localdch.nee = locala.KhF.xS();
        AppMethodBeat.o(193014);
        return 0;
      case 2: 
        localdch.version = locala.KhF.xS();
        AppMethodBeat.o(193014);
        return 0;
      case 3: 
        localdch.ASo = locala.KhF.readString();
        AppMethodBeat.o(193014);
        return 0;
      case 4: 
        localdch.EtM = locala.KhF.readString();
        AppMethodBeat.o(193014);
        return 0;
      case 5: 
        localdch.md5 = locala.KhF.readString();
        AppMethodBeat.o(193014);
        return 0;
      case 6: 
        localdch.yaG = locala.KhF.readString();
        AppMethodBeat.o(193014);
        return 0;
      case 7: 
        localdch.EtN = locala.KhF.readString();
        AppMethodBeat.o(193014);
        return 0;
      case 8: 
        localdch.wLF = locala.KhF.xT();
        AppMethodBeat.o(193014);
        return 0;
      }
      localdch.reportId = locala.KhF.xS();
      AppMethodBeat.o(193014);
      return 0;
    }
    AppMethodBeat.o(193014);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dch
 * JD-Core Version:    0.7.0.1
 */