package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class fnn
  extends com.tencent.mm.bx.a
{
  public long QzY;
  public String WET;
  public String abNy;
  public String abNz;
  public String mOI;
  public String mXG;
  public String md5;
  public int reportId;
  public int vST = -1;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258357);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.WET == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.abNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.mXG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.abNz == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.vST);
      paramVarArgs.bS(2, this.version);
      if (this.WET != null) {
        paramVarArgs.g(3, this.WET);
      }
      if (this.abNy != null) {
        paramVarArgs.g(4, this.abNy);
      }
      if (this.md5 != null) {
        paramVarArgs.g(5, this.md5);
      }
      if (this.mXG != null) {
        paramVarArgs.g(6, this.mXG);
      }
      if (this.abNz != null) {
        paramVarArgs.g(7, this.abNz);
      }
      paramVarArgs.bv(8, this.QzY);
      paramVarArgs.bS(9, this.reportId);
      if (this.mOI != null) {
        paramVarArgs.g(10, this.mOI);
      }
      AppMethodBeat.o(258357);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vST) + 0 + i.a.a.b.b.a.cJ(2, this.version);
      paramInt = i;
      if (this.WET != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.WET);
      }
      i = paramInt;
      if (this.abNy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abNy);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.md5);
      }
      i = paramInt;
      if (this.mXG != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.mXG);
      }
      paramInt = i;
      if (this.abNz != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abNz);
      }
      i = paramInt + i.a.a.b.b.a.q(8, this.QzY) + i.a.a.b.b.a.cJ(9, this.reportId);
      paramInt = i;
      if (this.mOI != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.mOI);
      }
      AppMethodBeat.o(258357);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.WET == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.abNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.mXG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      if (this.abNz == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(258357);
        throw paramVarArgs;
      }
      AppMethodBeat.o(258357);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fnn localfnn = (fnn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258357);
        return -1;
      case 1: 
        localfnn.vST = locala.ajGk.aar();
        AppMethodBeat.o(258357);
        return 0;
      case 2: 
        localfnn.version = locala.ajGk.aar();
        AppMethodBeat.o(258357);
        return 0;
      case 3: 
        localfnn.WET = locala.ajGk.readString();
        AppMethodBeat.o(258357);
        return 0;
      case 4: 
        localfnn.abNy = locala.ajGk.readString();
        AppMethodBeat.o(258357);
        return 0;
      case 5: 
        localfnn.md5 = locala.ajGk.readString();
        AppMethodBeat.o(258357);
        return 0;
      case 6: 
        localfnn.mXG = locala.ajGk.readString();
        AppMethodBeat.o(258357);
        return 0;
      case 7: 
        localfnn.abNz = locala.ajGk.readString();
        AppMethodBeat.o(258357);
        return 0;
      case 8: 
        localfnn.QzY = locala.ajGk.aaw();
        AppMethodBeat.o(258357);
        return 0;
      case 9: 
        localfnn.reportId = locala.ajGk.aar();
        AppMethodBeat.o(258357);
        return 0;
      }
      localfnn.mOI = locala.ajGk.readString();
      AppMethodBeat.o(258357);
      return 0;
    }
    AppMethodBeat.o(258357);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnn
 * JD-Core Version:    0.7.0.1
 */