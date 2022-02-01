package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ctm
  extends esc
{
  public LinkedList<fxr> ZeM;
  public b aapo;
  public int aapp;
  public LinkedList<wz> aazl;
  
  public ctm()
  {
    AppMethodBeat.i(258112);
    this.ZeM = new LinkedList();
    this.aazl = new LinkedList();
    AppMethodBeat.o(258112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258116);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZeM);
      if (this.aapo != null) {
        paramVarArgs.d(3, this.aapo);
      }
      paramVarArgs.e(4, 8, this.aazl);
      paramVarArgs.bS(5, this.aapp);
      AppMethodBeat.o(258116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZeM);
      paramInt = i;
      if (this.aapo != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aapo);
      }
      i = i.a.a.a.c(4, 8, this.aazl);
      int j = i.a.a.b.b.a.cJ(5, this.aapp);
      AppMethodBeat.o(258116);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZeM.clear();
        this.aazl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ctm localctm = (ctm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258116);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localctm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258116);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxr)localObject2).parseFrom((byte[])localObject1);
            }
            localctm.ZeM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258116);
          return 0;
        case 3: 
          localctm.aapo = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258116);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wz)localObject2).parseFrom((byte[])localObject1);
            }
            localctm.aazl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258116);
          return 0;
        }
        localctm.aapp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258116);
        return 0;
      }
      AppMethodBeat.o(258116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctm
 * JD-Core Version:    0.7.0.1
 */