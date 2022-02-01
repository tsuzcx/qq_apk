package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjl
  extends com.tencent.mm.bx.a
{
  public String YBM;
  public int ZOf;
  public bgh ZOh;
  public long ZOy;
  public String ZlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259959);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOh != null)
      {
        paramVarArgs.qD(1, this.ZOh.computeSize());
        this.ZOh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZOf);
      if (this.ZlX != null) {
        paramVarArgs.g(3, this.ZlX);
      }
      if (this.YBM != null) {
        paramVarArgs.g(4, this.YBM);
      }
      paramVarArgs.bv(5, this.ZOy);
      AppMethodBeat.o(259959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOh == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.ZOh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZOf);
      paramInt = i;
      if (this.ZlX != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZlX);
      }
      i = paramInt;
      if (this.YBM != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YBM);
      }
      paramInt = i.a.a.b.b.a.q(5, this.ZOy);
      AppMethodBeat.o(259959);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bjl localbjl = (bjl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259959);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bgh localbgh = new bgh();
            if ((localObject != null) && (localObject.length > 0)) {
              localbgh.parseFrom((byte[])localObject);
            }
            localbjl.ZOh = localbgh;
            paramInt += 1;
          }
          AppMethodBeat.o(259959);
          return 0;
        case 2: 
          localbjl.ZOf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259959);
          return 0;
        case 3: 
          localbjl.ZlX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259959);
          return 0;
        case 4: 
          localbjl.YBM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259959);
          return 0;
        }
        localbjl.ZOy = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259959);
        return 0;
      }
      AppMethodBeat.o(259959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjl
 * JD-Core Version:    0.7.0.1
 */