package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjn
  extends com.tencent.mm.bx.a
{
  public String YBM;
  public bgh ZOh;
  public long ZOy;
  public LinkedList<bjl> ZTd;
  public String ZlX;
  public int status;
  
  public bjn()
  {
    AppMethodBeat.i(259994);
    this.ZTd = new LinkedList();
    AppMethodBeat.o(259994);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259998);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBM != null) {
        paramVarArgs.g(1, this.YBM);
      }
      paramVarArgs.bv(2, this.ZOy);
      if (this.ZlX != null) {
        paramVarArgs.g(3, this.ZlX);
      }
      if (this.ZOh != null)
      {
        paramVarArgs.qD(4, this.ZOh.computeSize());
        this.ZOh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.status);
      paramVarArgs.e(6, 8, this.ZTd);
      AppMethodBeat.o(259998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBM == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = i.a.a.b.b.a.h(1, this.YBM) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZOy);
      paramInt = i;
      if (this.ZlX != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZlX);
      }
      i = paramInt;
      if (this.ZOh != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZOh.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.status);
      int j = i.a.a.a.c(6, 8, this.ZTd);
      AppMethodBeat.o(259998);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZTd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259998);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bjn localbjn = (bjn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259998);
          return -1;
        case 1: 
          localbjn.YBM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259998);
          return 0;
        case 2: 
          localbjn.ZOy = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259998);
          return 0;
        case 3: 
          localbjn.ZlX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259998);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjn.ZOh = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259998);
          return 0;
        case 5: 
          localbjn.status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259998);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjl)localObject2).parseFrom((byte[])localObject1);
          }
          localbjn.ZTd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259998);
        return 0;
      }
      AppMethodBeat.o(259998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjn
 * JD-Core Version:    0.7.0.1
 */