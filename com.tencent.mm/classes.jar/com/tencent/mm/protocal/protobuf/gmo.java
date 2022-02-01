package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmo
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> abUC;
  public gmn achK;
  public LinkedList<Integer> achL;
  public int achM;
  public int achN;
  
  public gmo()
  {
    AppMethodBeat.i(153338);
    this.achL = new LinkedList();
    this.abUC = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achK != null)
      {
        paramVarArgs.qD(1, this.achK.computeSize());
        this.achK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.achL);
      paramVarArgs.e(3, 2, this.abUC);
      paramVarArgs.bS(4, this.achM);
      paramVarArgs.bS(5, this.achN);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achK == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = i.a.a.a.qC(1, this.achK.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 2, this.achL);
      int j = i.a.a.a.c(3, 2, this.abUC);
      int k = i.a.a.b.b.a.cJ(4, this.achM);
      int m = i.a.a.b.b.a.cJ(5, this.achN);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.achL.clear();
        this.abUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmo localgmo = (gmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
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
            localgmo.achK = localgmn;
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localgmo.achL.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localgmo.abUC.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localgmo.achM = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153339);
          return 0;
        }
        localgmo.achN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmo
 * JD-Core Version:    0.7.0.1
 */