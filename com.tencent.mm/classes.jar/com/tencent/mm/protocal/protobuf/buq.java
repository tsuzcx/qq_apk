package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class buq
  extends esc
{
  public int BeA;
  public LinkedList<awt> aabt;
  public b aacl;
  
  public buq()
  {
    AppMethodBeat.i(259101);
    this.aabt = new LinkedList();
    AppMethodBeat.o(259101);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259106);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aacl != null) {
        paramVarArgs.d(2, this.aacl);
      }
      paramVarArgs.e(3, 8, this.aabt);
      paramVarArgs.bS(4, this.BeA);
      AppMethodBeat.o(259106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aacl != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.aacl);
      }
      paramInt = i.a.a.a.c(3, 8, this.aabt);
      int j = i.a.a.b.b.a.cJ(4, this.BeA);
      AppMethodBeat.o(259106);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aabt.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        buq localbuq = (buq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259106);
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
            localbuq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259106);
          return 0;
        case 2: 
          localbuq.aacl = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259106);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awt)localObject2).parseFrom((byte[])localObject1);
            }
            localbuq.aabt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259106);
          return 0;
        }
        localbuq.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259106);
        return 0;
      }
      AppMethodBeat.o(259106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buq
 * JD-Core Version:    0.7.0.1
 */