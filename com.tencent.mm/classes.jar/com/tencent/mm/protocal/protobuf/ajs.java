package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajs
  extends com.tencent.mm.bw.a
{
  public String EEs;
  public FinderContact contact;
  public boolean dfZ;
  public int displayFlag;
  public int drx;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.ln(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.drx);
      if (this.EEs != null) {
        paramVarArgs.d(3, this.EEs);
      }
      paramVarArgs.bl(4, this.dfZ);
      paramVarArgs.aR(5, this.displayFlag);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      AppMethodBeat.o(168954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.drx);
      paramInt = i;
      if (this.EEs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EEs);
      }
      i = paramInt + (f.a.a.b.b.a.fK(4) + 1) + f.a.a.b.b.a.bx(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajs localajs = (ajs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajs.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localajs.drx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localajs.EEs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localajs.dfZ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localajs.displayFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168954);
          return 0;
        }
        localajs.username = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajs
 * JD-Core Version:    0.7.0.1
 */