package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgq
  extends cqk
{
  public int CellCount;
  public LinkedList<duo> CellList;
  public String EVE;
  public String EVG;
  public int EVH;
  public String EVI;
  public String EVJ;
  public String EVK;
  
  public bgq()
  {
    AppMethodBeat.i(32305);
    this.CellList = new LinkedList();
    AppMethodBeat.o(32305);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32306);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CellCount);
      paramVarArgs.e(3, 8, this.CellList);
      if (this.EVG != null) {
        paramVarArgs.d(4, this.EVG);
      }
      if (this.EVE != null) {
        paramVarArgs.d(5, this.EVE);
      }
      paramVarArgs.aR(6, this.EVH);
      if (this.EVI != null) {
        paramVarArgs.d(7, this.EVI);
      }
      if (this.EVJ != null) {
        paramVarArgs.d(8, this.EVJ);
      }
      if (this.EVK != null) {
        paramVarArgs.d(9, this.EVK);
      }
      AppMethodBeat.o(32306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label909;
      }
    }
    label909:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.CellCount) + f.a.a.a.c(3, 8, this.CellList);
      paramInt = i;
      if (this.EVG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EVG);
      }
      i = paramInt;
      if (this.EVE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EVE);
      }
      i += f.a.a.b.b.a.bx(6, this.EVH);
      paramInt = i;
      if (this.EVI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EVI);
      }
      i = paramInt;
      if (this.EVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EVJ);
      }
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EVK);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CellList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32306);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgq localbgq = (bgq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localbgq.CellCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgq.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localbgq.EVG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localbgq.EVE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localbgq.EVH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localbgq.EVI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localbgq.EVJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localbgq.EVK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgq
 * JD-Core Version:    0.7.0.1
 */