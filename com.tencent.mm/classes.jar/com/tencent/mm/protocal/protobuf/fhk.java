package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fhk
  extends com.tencent.mm.bx.a
{
  public String abHX;
  public String abHY;
  public String abHZ;
  public String abIa;
  public int oUi;
  public int oUj;
  public int oUk;
  public int oUl;
  public int opType;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abHX == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.abHY == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.abHZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.abIa == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.opType);
      paramVarArgs.bS(2, this.oUl);
      paramVarArgs.bS(3, this.oUi);
      paramVarArgs.bv(4, this.timeStamp);
      paramVarArgs.bS(5, this.oUj);
      paramVarArgs.bS(6, this.oUk);
      if (this.abHX != null) {
        paramVarArgs.g(7, this.abHX);
      }
      if (this.abHY != null) {
        paramVarArgs.g(8, this.abHY);
      }
      if (this.abHZ != null) {
        paramVarArgs.g(9, this.abHZ);
      }
      if (this.abIa != null) {
        paramVarArgs.g(10, this.abIa);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.opType) + 0 + i.a.a.b.b.a.cJ(2, this.oUl) + i.a.a.b.b.a.cJ(3, this.oUi) + i.a.a.b.b.a.q(4, this.timeStamp) + i.a.a.b.b.a.cJ(5, this.oUj) + i.a.a.b.b.a.cJ(6, this.oUk);
      paramInt = i;
      if (this.abHX != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abHX);
      }
      i = paramInt;
      if (this.abHY != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abHY);
      }
      paramInt = i;
      if (this.abHZ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abHZ);
      }
      i = paramInt;
      if (this.abIa != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abIa);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abHX == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.abHY == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.abHZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.abIa == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fhk localfhk = (fhk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localfhk.opType = locala.ajGk.aar();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localfhk.oUl = locala.ajGk.aar();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localfhk.oUi = locala.ajGk.aar();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localfhk.timeStamp = locala.ajGk.aaw();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localfhk.oUj = locala.ajGk.aar();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localfhk.oUk = locala.ajGk.aar();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localfhk.abHX = locala.ajGk.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localfhk.abHY = locala.ajGk.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localfhk.abHZ = locala.ajGk.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localfhk.abIa = locala.ajGk.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhk
 * JD-Core Version:    0.7.0.1
 */