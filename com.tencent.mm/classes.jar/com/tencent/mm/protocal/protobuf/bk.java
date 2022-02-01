package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bk
  extends com.tencent.mm.cd.a
{
  public bl RGt;
  public bl RGu;
  public bl RGv;
  public bl RGw;
  public bl RGx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RGt != null)
      {
        paramVarArgs.oE(1, this.RGt.computeSize());
        this.RGt.writeFields(paramVarArgs);
      }
      if (this.RGu != null)
      {
        paramVarArgs.oE(2, this.RGu.computeSize());
        this.RGu.writeFields(paramVarArgs);
      }
      if (this.RGv != null)
      {
        paramVarArgs.oE(3, this.RGv.computeSize());
        this.RGv.writeFields(paramVarArgs);
      }
      if (this.RGw != null)
      {
        paramVarArgs.oE(4, this.RGw.computeSize());
        this.RGw.writeFields(paramVarArgs);
      }
      if (this.RGx != null)
      {
        paramVarArgs.oE(5, this.RGx.computeSize());
        this.RGx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RGt == null) {
        break label816;
      }
    }
    label816:
    for (int i = g.a.a.a.oD(1, this.RGt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RGu != null) {
        paramInt = i + g.a.a.a.oD(2, this.RGu.computeSize());
      }
      i = paramInt;
      if (this.RGv != null) {
        i = paramInt + g.a.a.a.oD(3, this.RGv.computeSize());
      }
      paramInt = i;
      if (this.RGw != null) {
        paramInt = i + g.a.a.a.oD(4, this.RGw.computeSize());
      }
      i = paramInt;
      if (this.RGx != null) {
        i = paramInt + g.a.a.a.oD(5, this.RGx.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bk localbk = (bk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        bl localbl;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122481);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbl = new bl();
            if ((localObject != null) && (localObject.length > 0)) {
              localbl.parseFrom((byte[])localObject);
            }
            localbk.RGt = localbl;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbl = new bl();
            if ((localObject != null) && (localObject.length > 0)) {
              localbl.parseFrom((byte[])localObject);
            }
            localbk.RGu = localbl;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbl = new bl();
            if ((localObject != null) && (localObject.length > 0)) {
              localbl.parseFrom((byte[])localObject);
            }
            localbk.RGv = localbl;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbl = new bl();
            if ((localObject != null) && (localObject.length > 0)) {
              localbl.parseFrom((byte[])localObject);
            }
            localbk.RGw = localbl;
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbl = new bl();
          if ((localObject != null) && (localObject.length > 0)) {
            localbl.parseFrom((byte[])localObject);
          }
          localbk.RGx = localbl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */