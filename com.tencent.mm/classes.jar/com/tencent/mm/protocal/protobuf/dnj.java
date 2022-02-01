package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class dnj
  extends com.tencent.mm.bx.a
{
  public String AFz;
  public String DNG;
  public String HBu;
  public String HBv;
  public String md5;
  public int ojt = -1;
  public int reportId;
  public int version;
  public long zok;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.HBu == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.AFz == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.HBv == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ojt);
      paramVarArgs.aS(2, this.version);
      if (this.DNG != null) {
        paramVarArgs.d(3, this.DNG);
      }
      if (this.HBu != null) {
        paramVarArgs.d(4, this.HBu);
      }
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      if (this.AFz != null) {
        paramVarArgs.d(6, this.AFz);
      }
      if (this.HBv != null) {
        paramVarArgs.d(7, this.HBv);
      }
      paramVarArgs.aY(8, this.zok);
      paramVarArgs.aS(9, this.reportId);
      AppMethodBeat.o(209607);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ojt) + 0 + f.a.a.b.b.a.bz(2, this.version);
      paramInt = i;
      if (this.DNG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DNG);
      }
      i = paramInt;
      if (this.HBu != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HBu);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt;
      if (this.AFz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.AFz);
      }
      paramInt = i;
      if (this.HBv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HBv);
      }
      i = f.a.a.b.b.a.p(8, this.zok);
      int j = f.a.a.b.b.a.bz(9, this.reportId);
      AppMethodBeat.o(209607);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.DNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.HBu == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.AFz == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      if (this.HBv == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(209607);
        throw paramVarArgs;
      }
      AppMethodBeat.o(209607);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnj localdnj = (dnj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209607);
        return -1;
      case 1: 
        localdnj.ojt = locala.NPN.zc();
        AppMethodBeat.o(209607);
        return 0;
      case 2: 
        localdnj.version = locala.NPN.zc();
        AppMethodBeat.o(209607);
        return 0;
      case 3: 
        localdnj.DNG = locala.NPN.readString();
        AppMethodBeat.o(209607);
        return 0;
      case 4: 
        localdnj.HBu = locala.NPN.readString();
        AppMethodBeat.o(209607);
        return 0;
      case 5: 
        localdnj.md5 = locala.NPN.readString();
        AppMethodBeat.o(209607);
        return 0;
      case 6: 
        localdnj.AFz = locala.NPN.readString();
        AppMethodBeat.o(209607);
        return 0;
      case 7: 
        localdnj.HBv = locala.NPN.readString();
        AppMethodBeat.o(209607);
        return 0;
      case 8: 
        localdnj.zok = locala.NPN.zd();
        AppMethodBeat.o(209607);
        return 0;
      }
      localdnj.reportId = locala.NPN.zc();
      AppMethodBeat.o(209607);
      return 0;
    }
    AppMethodBeat.o(209607);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnj
 * JD-Core Version:    0.7.0.1
 */