package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class awp
  extends dyy
{
  public b SDI;
  public int SHA;
  public bbl SHr;
  public bjt SIh;
  public awn SJl;
  public LinkedList<FinderObject> object;
  public int xFI;
  
  public awp()
  {
    AppMethodBeat.i(231380);
    this.object = new LinkedList();
    AppMethodBeat.o(231380);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231385);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.aY(4, this.xFI);
      if (this.SHr != null)
      {
        paramVarArgs.oE(5, this.SHr.computeSize());
        this.SHr.writeFields(paramVarArgs);
      }
      if (this.SIh != null)
      {
        paramVarArgs.oE(6, this.SIh.computeSize());
        this.SIh.writeFields(paramVarArgs);
      }
      if (this.SJl != null)
      {
        paramVarArgs.oE(7, this.SJl.computeSize());
        this.SJl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SHA);
      AppMethodBeat.o(231385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label956;
      }
    }
    label956:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.SDI != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SDI);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.xFI);
      paramInt = i;
      if (this.SHr != null) {
        paramInt = i + g.a.a.a.oD(5, this.SHr.computeSize());
      }
      i = paramInt;
      if (this.SIh != null) {
        i = paramInt + g.a.a.a.oD(6, this.SIh.computeSize());
      }
      paramInt = i;
      if (this.SJl != null) {
        paramInt = i + g.a.a.a.oD(7, this.SJl.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.SHA);
      AppMethodBeat.o(231385);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awp localawp = (awp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231385);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localawp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231385);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localawp.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231385);
          return 0;
        case 3: 
          localawp.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231385);
          return 0;
        case 4: 
          localawp.xFI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231385);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbl)localObject2).parseFrom((byte[])localObject1);
            }
            localawp.SHr = ((bbl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231385);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjt)localObject2).parseFrom((byte[])localObject1);
            }
            localawp.SIh = ((bjt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231385);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awn)localObject2).parseFrom((byte[])localObject1);
            }
            localawp.SJl = ((awn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231385);
          return 0;
        }
        localawp.SHA = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(231385);
        return 0;
      }
      AppMethodBeat.o(231385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awp
 * JD-Core Version:    0.7.0.1
 */