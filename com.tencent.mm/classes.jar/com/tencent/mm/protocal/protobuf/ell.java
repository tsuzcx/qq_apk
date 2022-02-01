package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ell
  extends dyy
{
  public LinkedList<SnsObject> RPF;
  public int TGK;
  public elj TxL;
  public String UlA;
  public int UlE;
  public ekt UlF;
  public int UlZ;
  public LinkedList<elo> Uma;
  public long UnA;
  public long UnB;
  public String UnC;
  public boolean UnD;
  public int Unb;
  public int Unz;
  
  public ell()
  {
    AppMethodBeat.i(125836);
    this.RPF = new LinkedList();
    this.Uma = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UlA != null) {
        paramVarArgs.f(2, this.UlA);
      }
      paramVarArgs.aY(3, this.TGK);
      paramVarArgs.e(4, 8, this.RPF);
      paramVarArgs.aY(5, this.Unz);
      if (this.TxL != null)
      {
        paramVarArgs.oE(6, this.TxL.computeSize());
        this.TxL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.Unb);
      paramVarArgs.aY(8, this.UlE);
      if (this.UlF != null)
      {
        paramVarArgs.oE(9, this.UlF.computeSize());
        this.UlF.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(10, this.UnA);
      paramVarArgs.bm(11, this.UnB);
      if (this.UnC != null) {
        paramVarArgs.f(12, this.UnC);
      }
      paramVarArgs.aY(13, this.UlZ);
      paramVarArgs.e(14, 8, this.Uma);
      paramVarArgs.co(15, this.UnD);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1324;
      }
    }
    label1324:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UlA);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TGK) + g.a.a.a.c(4, 8, this.RPF) + g.a.a.b.b.a.bM(5, this.Unz);
      paramInt = i;
      if (this.TxL != null) {
        paramInt = i + g.a.a.a.oD(6, this.TxL.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Unb) + g.a.a.b.b.a.bM(8, this.UlE);
      paramInt = i;
      if (this.UlF != null) {
        paramInt = i + g.a.a.a.oD(9, this.UlF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(10, this.UnA) + g.a.a.b.b.a.p(11, this.UnB);
      paramInt = i;
      if (this.UnC != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UnC);
      }
      i = g.a.a.b.b.a.bM(13, this.UlZ);
      int j = g.a.a.a.c(14, 8, this.Uma);
      int k = g.a.a.b.b.a.gL(15);
      AppMethodBeat.o(125837);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPF.clear();
        this.Uma.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ell localell = (ell)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
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
            localell.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localell.UlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localell.TGK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localell.RPF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localell.Unz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elj)localObject2).parseFrom((byte[])localObject1);
            }
            localell.TxL = ((elj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localell.Unb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localell.UlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekt)localObject2).parseFrom((byte[])localObject1);
            }
            localell.UlF = ((ekt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localell.UnA = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localell.UnB = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localell.UnC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localell.UlZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elo)localObject2).parseFrom((byte[])localObject1);
            }
            localell.Uma.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        }
        localell.UnD = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ell
 * JD-Core Version:    0.7.0.1
 */