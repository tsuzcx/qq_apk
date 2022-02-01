package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbu
  extends dyl
{
  public int Tkg;
  public int Tkh;
  public vh Tki;
  public long Tkj;
  public aaz Tkk;
  public int Tkl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Tkg);
      paramVarArgs.aY(3, this.Tkh);
      if (this.Tki != null)
      {
        paramVarArgs.oE(4, this.Tki.computeSize());
        this.Tki.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.Tkj);
      if (this.Tkk != null)
      {
        paramVarArgs.oE(6, this.Tkk.computeSize());
        this.Tkk.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.Tkl);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Tkg) + g.a.a.b.b.a.bM(3, this.Tkh);
      paramInt = i;
      if (this.Tki != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tki.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.Tkj);
      paramInt = i;
      if (this.Tkk != null) {
        paramInt = i + g.a.a.a.oD(6, this.Tkk.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.Tkl);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbu localcbu = (cbu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcbu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localcbu.Tkg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localcbu.Tkh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vh)localObject2).parseFrom((byte[])localObject1);
            }
            localcbu.Tki = ((vh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localcbu.Tkj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aaz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aaz)localObject2).parseFrom((byte[])localObject1);
            }
            localcbu.Tkk = ((aaz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localcbu.Tkl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbu
 * JD-Core Version:    0.7.0.1
 */