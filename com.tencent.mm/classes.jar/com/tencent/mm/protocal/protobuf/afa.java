package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afa
  extends com.tencent.mm.bx.a
{
  public enx Znc;
  public LinkedList<jy> Znd;
  public boolean Zne;
  public enx Znf;
  
  public afa()
  {
    AppMethodBeat.i(260154);
    this.Znd = new LinkedList();
    AppMethodBeat.o(260154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260163);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Znc != null)
      {
        paramVarArgs.qD(1, this.Znc.computeSize());
        this.Znc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Znd);
      paramVarArgs.di(3, this.Zne);
      if (this.Znf != null)
      {
        paramVarArgs.qD(4, this.Znf.computeSize());
        this.Znf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260163);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Znc == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = i.a.a.a.qC(1, this.Znc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.Znd) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.Znf != null) {
        paramInt = i + i.a.a.a.qC(4, this.Znf.computeSize());
      }
      AppMethodBeat.o(260163);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Znd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260163);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        afa localafa = (afa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260163);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enx)localObject2).parseFrom((byte[])localObject1);
            }
            localafa.Znc = ((enx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260163);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jy)localObject2).parseFrom((byte[])localObject1);
            }
            localafa.Znd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260163);
          return 0;
        case 3: 
          localafa.Zne = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(260163);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new enx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((enx)localObject2).parseFrom((byte[])localObject1);
          }
          localafa.Znf = ((enx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260163);
        return 0;
      }
      AppMethodBeat.o(260163);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afa
 * JD-Core Version:    0.7.0.1
 */