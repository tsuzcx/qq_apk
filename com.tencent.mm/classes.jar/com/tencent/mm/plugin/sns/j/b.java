package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvt;
import java.util.LinkedList;

public class b
  extends com.tencent.mm.cd.a
{
  public int KeQ;
  public int createTime;
  public cvt fVT;
  public String parentId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96151);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fVT != null)
      {
        paramVarArgs.oE(1, this.fVT.computeSize());
        this.fVT.writeFields(paramVarArgs);
      }
      if (this.parentId != null) {
        paramVarArgs.f(2, this.parentId);
      }
      paramVarArgs.aY(3, this.createTime);
      paramVarArgs.aY(4, this.KeQ);
      AppMethodBeat.o(96151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVT == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.a.oD(1, this.fVT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.parentId != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.parentId);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.createTime);
      int j = g.a.a.b.b.a.bM(4, this.KeQ);
      AppMethodBeat.o(96151);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(96151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96151);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cvt localcvt = new cvt();
            if ((localObject != null) && (localObject.length > 0)) {
              localcvt.parseFrom((byte[])localObject);
            }
            localb.fVT = localcvt;
            paramInt += 1;
          }
          AppMethodBeat.o(96151);
          return 0;
        case 2: 
          localb.parentId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(96151);
          return 0;
        case 3: 
          localb.createTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(96151);
          return 0;
        }
        localb.KeQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(96151);
        return 0;
      }
      AppMethodBeat.o(96151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.b
 * JD-Core Version:    0.7.0.1
 */