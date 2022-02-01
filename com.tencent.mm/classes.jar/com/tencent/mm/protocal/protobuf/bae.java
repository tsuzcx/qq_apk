package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bae
  extends erp
{
  public int ABS;
  public int ACA;
  public b AyB;
  public atz CJv;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168988);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ABS);
      if (this.AyB != null) {
        paramVarArgs.d(3, this.AyB);
      }
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      paramVarArgs.bS(5, this.scene);
      if (this.CJv != null)
      {
        paramVarArgs.qD(6, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.ACA);
      AppMethodBeat.o(168988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ABS);
      paramInt = i;
      if (this.AyB != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.AyB);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.username);
      }
      i += i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(6, this.CJv.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.ACA);
      AppMethodBeat.o(168988);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bae localbae = (bae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168988);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbae.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        case 2: 
          localbae.ABS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168988);
          return 0;
        case 3: 
          localbae.AyB = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168988);
          return 0;
        case 4: 
          localbae.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168988);
          return 0;
        case 5: 
          localbae.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168988);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbae.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        }
        localbae.ACA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168988);
        return 0;
      }
      AppMethodBeat.o(168988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bae
 * JD-Core Version:    0.7.0.1
 */