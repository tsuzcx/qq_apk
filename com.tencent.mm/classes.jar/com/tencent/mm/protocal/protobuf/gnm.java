package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gnm
  extends com.tencent.mm.bx.a
{
  public String aciA;
  public int aciB;
  public String acix;
  public String aciy;
  public LinkedList<dzg> aciz;
  public String hAP;
  
  public gnm()
  {
    AppMethodBeat.i(50125);
    this.aciz = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acix != null) {
        paramVarArgs.g(1, this.acix);
      }
      if (this.aciy != null) {
        paramVarArgs.g(2, this.aciy);
      }
      paramVarArgs.e(3, 8, this.aciz);
      if (this.aciA != null) {
        paramVarArgs.g(4, this.aciA);
      }
      paramVarArgs.bS(5, this.aciB);
      if (this.hAP != null) {
        paramVarArgs.g(6, this.hAP);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acix == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = i.a.a.b.b.a.h(1, this.acix) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aciy != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aciy);
      }
      i += i.a.a.a.c(3, 8, this.aciz);
      paramInt = i;
      if (this.aciA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aciA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aciB);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hAP);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aciz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gnm localgnm = (gnm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localgnm.acix = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localgnm.aciy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dzg localdzg = new dzg();
            if ((localObject != null) && (localObject.length > 0)) {
              localdzg.parseFrom((byte[])localObject);
            }
            localgnm.aciz.add(localdzg);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localgnm.aciA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localgnm.aciB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(50126);
          return 0;
        }
        localgnm.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnm
 * JD-Core Version:    0.7.0.1
 */