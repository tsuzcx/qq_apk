package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmw
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> abUC;
  public gmn achK;
  public String acif;
  public int acig;
  public int acih;
  
  public gmw()
  {
    AppMethodBeat.i(153345);
    this.abUC = new LinkedList();
    AppMethodBeat.o(153345);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153346);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achK != null)
      {
        paramVarArgs.qD(1, this.achK.computeSize());
        this.achK.writeFields(paramVarArgs);
      }
      if (this.acif != null) {
        paramVarArgs.g(2, this.acif);
      }
      paramVarArgs.e(3, 2, this.abUC);
      paramVarArgs.bS(4, this.acig);
      paramVarArgs.bS(5, this.acih);
      AppMethodBeat.o(153346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achK == null) {
        break label499;
      }
    }
    label499:
    for (paramInt = i.a.a.a.qC(1, this.achK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acif != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.acif);
      }
      paramInt = i.a.a.a.c(3, 2, this.abUC);
      int j = i.a.a.b.b.a.cJ(4, this.acig);
      int k = i.a.a.b.b.a.cJ(5, this.acih);
      AppMethodBeat.o(153346);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmw localgmw = (gmw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153346);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gmn localgmn = new gmn();
            if ((localObject != null) && (localObject.length > 0)) {
              localgmn.parseFrom((byte[])localObject);
            }
            localgmw.achK = localgmn;
            paramInt += 1;
          }
          AppMethodBeat.o(153346);
          return 0;
        case 2: 
          localgmw.acif = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153346);
          return 0;
        case 3: 
          localgmw.abUC.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(153346);
          return 0;
        case 4: 
          localgmw.acig = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153346);
          return 0;
        }
        localgmw.acih = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153346);
        return 0;
      }
      AppMethodBeat.o(153346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmw
 * JD-Core Version:    0.7.0.1
 */