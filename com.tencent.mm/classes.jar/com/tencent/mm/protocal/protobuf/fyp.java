package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fyp
  extends com.tencent.mm.bx.a
{
  public String ZmG;
  public long ZnE;
  public String abWb;
  public String abWc;
  public String abWp;
  public b abWq;
  public LinkedList<fyy> abWr;
  
  public fyp()
  {
    AppMethodBeat.i(257602);
    this.abWr = new LinkedList();
    AppMethodBeat.o(257602);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257606);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abWb != null) {
        paramVarArgs.g(1, this.abWb);
      }
      paramVarArgs.bv(2, this.ZnE);
      if (this.abWc != null) {
        paramVarArgs.g(3, this.abWc);
      }
      if (this.abWp != null) {
        paramVarArgs.g(4, this.abWp);
      }
      if (this.ZmG != null) {
        paramVarArgs.g(5, this.ZmG);
      }
      if (this.abWq != null) {
        paramVarArgs.d(6, this.abWq);
      }
      paramVarArgs.e(7, 8, this.abWr);
      AppMethodBeat.o(257606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abWb == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = i.a.a.b.b.a.h(1, this.abWb) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZnE);
      paramInt = i;
      if (this.abWc != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abWc);
      }
      i = paramInt;
      if (this.abWp != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abWp);
      }
      paramInt = i;
      if (this.ZmG != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZmG);
      }
      i = paramInt;
      if (this.abWq != null) {
        i = paramInt + i.a.a.b.b.a.c(6, this.abWq);
      }
      paramInt = i.a.a.a.c(7, 8, this.abWr);
      AppMethodBeat.o(257606);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fyp localfyp = (fyp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257606);
          return -1;
        case 1: 
          localfyp.abWb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257606);
          return 0;
        case 2: 
          localfyp.ZnE = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257606);
          return 0;
        case 3: 
          localfyp.abWc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257606);
          return 0;
        case 4: 
          localfyp.abWp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257606);
          return 0;
        case 5: 
          localfyp.ZmG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257606);
          return 0;
        case 6: 
          localfyp.abWq = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(257606);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fyy localfyy = new fyy();
          if ((localObject != null) && (localObject.length > 0)) {
            localfyy.parseFrom((byte[])localObject);
          }
          localfyp.abWr.add(localfyy);
          paramInt += 1;
        }
        AppMethodBeat.o(257606);
        return 0;
      }
      AppMethodBeat.o(257606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyp
 * JD-Core Version:    0.7.0.1
 */