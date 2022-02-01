package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bs
  extends com.tencent.mm.bx.a
{
  public bt YDn;
  public bt YDo;
  public bt YDp;
  public bt YDq;
  public bt YDr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YDn != null)
      {
        paramVarArgs.qD(1, this.YDn.computeSize());
        this.YDn.writeFields(paramVarArgs);
      }
      if (this.YDo != null)
      {
        paramVarArgs.qD(2, this.YDo.computeSize());
        this.YDo.writeFields(paramVarArgs);
      }
      if (this.YDp != null)
      {
        paramVarArgs.qD(3, this.YDp.computeSize());
        this.YDp.writeFields(paramVarArgs);
      }
      if (this.YDq != null)
      {
        paramVarArgs.qD(4, this.YDq.computeSize());
        this.YDq.writeFields(paramVarArgs);
      }
      if (this.YDr != null)
      {
        paramVarArgs.qD(5, this.YDr.computeSize());
        this.YDr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YDn == null) {
        break label812;
      }
    }
    label812:
    for (int i = i.a.a.a.qC(1, this.YDn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YDo != null) {
        paramInt = i + i.a.a.a.qC(2, this.YDo.computeSize());
      }
      i = paramInt;
      if (this.YDp != null) {
        i = paramInt + i.a.a.a.qC(3, this.YDp.computeSize());
      }
      paramInt = i;
      if (this.YDq != null) {
        paramInt = i + i.a.a.a.qC(4, this.YDq.computeSize());
      }
      i = paramInt;
      if (this.YDr != null) {
        i = paramInt + i.a.a.a.qC(5, this.YDr.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bs localbs = (bs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        bt localbt;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122481);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbt = new bt();
            if ((localObject != null) && (localObject.length > 0)) {
              localbt.parseFrom((byte[])localObject);
            }
            localbs.YDn = localbt;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbt = new bt();
            if ((localObject != null) && (localObject.length > 0)) {
              localbt.parseFrom((byte[])localObject);
            }
            localbs.YDo = localbt;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbt = new bt();
            if ((localObject != null) && (localObject.length > 0)) {
              localbt.parseFrom((byte[])localObject);
            }
            localbs.YDp = localbt;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbt = new bt();
            if ((localObject != null) && (localObject.length > 0)) {
              localbt.parseFrom((byte[])localObject);
            }
            localbs.YDq = localbt;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbt = new bt();
          if ((localObject != null) && (localObject.length > 0)) {
            localbt.parseFrom((byte[])localObject);
          }
          localbs.YDr = localbt;
          paramInt += 1;
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      AppMethodBeat.o(122481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bs
 * JD-Core Version:    0.7.0.1
 */