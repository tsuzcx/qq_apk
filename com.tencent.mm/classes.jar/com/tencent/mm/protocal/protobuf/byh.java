package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class byh
  extends erp
{
  public atz CJv;
  public b Zsu;
  public String aahb;
  public int dIY;
  public int osy;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169068);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.osy);
      paramVarArgs.bS(3, this.dIY);
      if (this.Zsu != null) {
        paramVarArgs.d(4, this.Zsu);
      }
      if (this.aahb != null) {
        paramVarArgs.g(5, this.aahb);
      }
      paramVarArgs.bS(6, this.scene);
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.osy) + i.a.a.b.b.a.cJ(3, this.dIY);
      paramInt = i;
      if (this.Zsu != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.Zsu);
      }
      i = paramInt;
      if (this.aahb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aahb);
      }
      i += i.a.a.b.b.a.cJ(6, this.scene);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      AppMethodBeat.o(169068);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byh localbyh = (byh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169068);
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
            localbyh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169068);
          return 0;
        case 2: 
          localbyh.osy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169068);
          return 0;
        case 3: 
          localbyh.dIY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169068);
          return 0;
        case 4: 
          localbyh.Zsu = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169068);
          return 0;
        case 5: 
          localbyh.aahb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169068);
          return 0;
        case 6: 
          localbyh.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169068);
          return 0;
        }
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
          localbyh.CJv = ((atz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      AppMethodBeat.o(169068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byh
 * JD-Core Version:    0.7.0.1
 */