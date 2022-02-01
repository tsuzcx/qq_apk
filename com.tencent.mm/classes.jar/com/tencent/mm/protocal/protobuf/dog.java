package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class dog
  extends com.tencent.mm.bw.a
{
  public String AXc;
  public String EfF;
  public String HVh;
  public String HVi;
  public String md5;
  public int opt = -1;
  public int reportId;
  public int version;
  public long zFz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EfF == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.HVh == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.AXc == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.HVi == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.opt);
      paramVarArgs.aS(2, this.version);
      if (this.EfF != null) {
        paramVarArgs.d(3, this.EfF);
      }
      if (this.HVh != null) {
        paramVarArgs.d(4, this.HVh);
      }
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      if (this.AXc != null) {
        paramVarArgs.d(6, this.AXc);
      }
      if (this.HVi != null) {
        paramVarArgs.d(7, this.HVi);
      }
      paramVarArgs.aZ(8, this.zFz);
      paramVarArgs.aS(9, this.reportId);
      AppMethodBeat.o(208564);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.opt) + 0 + f.a.a.b.b.a.bz(2, this.version);
      paramInt = i;
      if (this.EfF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EfF);
      }
      i = paramInt;
      if (this.HVh != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HVh);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt;
      if (this.AXc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.AXc);
      }
      paramInt = i;
      if (this.HVi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HVi);
      }
      i = f.a.a.b.b.a.p(8, this.zFz);
      int j = f.a.a.b.b.a.bz(9, this.reportId);
      AppMethodBeat.o(208564);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.EfF == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.HVh == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.AXc == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      if (this.HVi == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(208564);
        throw paramVarArgs;
      }
      AppMethodBeat.o(208564);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dog localdog = (dog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208564);
        return -1;
      case 1: 
        localdog.opt = locala.OmT.zc();
        AppMethodBeat.o(208564);
        return 0;
      case 2: 
        localdog.version = locala.OmT.zc();
        AppMethodBeat.o(208564);
        return 0;
      case 3: 
        localdog.EfF = locala.OmT.readString();
        AppMethodBeat.o(208564);
        return 0;
      case 4: 
        localdog.HVh = locala.OmT.readString();
        AppMethodBeat.o(208564);
        return 0;
      case 5: 
        localdog.md5 = locala.OmT.readString();
        AppMethodBeat.o(208564);
        return 0;
      case 6: 
        localdog.AXc = locala.OmT.readString();
        AppMethodBeat.o(208564);
        return 0;
      case 7: 
        localdog.HVi = locala.OmT.readString();
        AppMethodBeat.o(208564);
        return 0;
      case 8: 
        localdog.zFz = locala.OmT.zd();
        AppMethodBeat.o(208564);
        return 0;
      }
      localdog.reportId = locala.OmT.zc();
      AppMethodBeat.o(208564);
      return 0;
    }
    AppMethodBeat.o(208564);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dog
 * JD-Core Version:    0.7.0.1
 */