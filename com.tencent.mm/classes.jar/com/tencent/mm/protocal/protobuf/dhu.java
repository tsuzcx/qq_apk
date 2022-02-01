package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class dhu
  extends com.tencent.mm.bw.a
{
  public String CkB;
  public String FQO;
  public String FQP;
  public String md5;
  public int nGQ = -1;
  public int reportId;
  public int version;
  public long xYl;
  public String znF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198790);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CkB == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.FQO == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.znF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.FQP == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.nGQ);
      paramVarArgs.aR(2, this.version);
      if (this.CkB != null) {
        paramVarArgs.d(3, this.CkB);
      }
      if (this.FQO != null) {
        paramVarArgs.d(4, this.FQO);
      }
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      if (this.znF != null) {
        paramVarArgs.d(6, this.znF);
      }
      if (this.FQP != null) {
        paramVarArgs.d(7, this.FQP);
      }
      paramVarArgs.aO(8, this.xYl);
      paramVarArgs.aR(9, this.reportId);
      AppMethodBeat.o(198790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.nGQ) + 0 + f.a.a.b.b.a.bx(2, this.version);
      paramInt = i;
      if (this.CkB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CkB);
      }
      i = paramInt;
      if (this.FQO != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FQO);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt;
      if (this.znF != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.znF);
      }
      paramInt = i;
      if (this.FQP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQP);
      }
      i = f.a.a.b.b.a.p(8, this.xYl);
      int j = f.a.a.b.b.a.bx(9, this.reportId);
      AppMethodBeat.o(198790);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.CkB == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.FQO == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.znF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      if (this.FQP == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(198790);
        throw paramVarArgs;
      }
      AppMethodBeat.o(198790);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhu localdhu = (dhu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198790);
        return -1;
      case 1: 
        localdhu.nGQ = locala.LVo.xF();
        AppMethodBeat.o(198790);
        return 0;
      case 2: 
        localdhu.version = locala.LVo.xF();
        AppMethodBeat.o(198790);
        return 0;
      case 3: 
        localdhu.CkB = locala.LVo.readString();
        AppMethodBeat.o(198790);
        return 0;
      case 4: 
        localdhu.FQO = locala.LVo.readString();
        AppMethodBeat.o(198790);
        return 0;
      case 5: 
        localdhu.md5 = locala.LVo.readString();
        AppMethodBeat.o(198790);
        return 0;
      case 6: 
        localdhu.znF = locala.LVo.readString();
        AppMethodBeat.o(198790);
        return 0;
      case 7: 
        localdhu.FQP = locala.LVo.readString();
        AppMethodBeat.o(198790);
        return 0;
      case 8: 
        localdhu.xYl = locala.LVo.xG();
        AppMethodBeat.o(198790);
        return 0;
      }
      localdhu.reportId = locala.LVo.xF();
      AppMethodBeat.o(198790);
      return 0;
    }
    AppMethodBeat.o(198790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhu
 * JD-Core Version:    0.7.0.1
 */