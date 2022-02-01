package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ees
  extends dop
{
  public LinkedList<Integer> MNJ;
  public String MVO;
  public String MVP;
  public String dHx;
  public String dNI;
  
  public ees()
  {
    AppMethodBeat.i(123656);
    this.MNJ = new LinkedList();
    AppMethodBeat.o(123656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123657);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.e(3, 2, this.MNJ);
      if (this.MVO != null) {
        paramVarArgs.e(4, this.MVO);
      }
      if (this.dHx != null) {
        paramVarArgs.e(5, this.dHx);
      }
      if (this.MVP != null) {
        paramVarArgs.e(6, this.MVP);
      }
      AppMethodBeat.o(123657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      i += g.a.a.a.c(3, 2, this.MNJ);
      paramInt = i;
      if (this.MVO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MVO);
      }
      i = paramInt;
      if (this.dHx != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dHx);
      }
      paramInt = i;
      if (this.MVP != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MVP);
      }
      AppMethodBeat.o(123657);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MNJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ees localees = (ees)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123657);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localees.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123657);
          return 0;
        case 2: 
          localees.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 3: 
          localees.MNJ.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(123657);
          return 0;
        case 4: 
          localees.MVO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 5: 
          localees.dHx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123657);
          return 0;
        }
        localees.MVP = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123657);
        return 0;
      }
      AppMethodBeat.o(123657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ees
 * JD-Core Version:    0.7.0.1
 */