package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bop
  extends dyl
{
  public int CPw;
  public int RKI;
  public int RNa;
  public int RPJ;
  public int SZH;
  public String SZI;
  public LinkedList<boo> SZJ;
  public LinkedList<b> SZK;
  public String sSU;
  
  public bop()
  {
    AppMethodBeat.i(152547);
    this.SZJ = new LinkedList();
    this.SZK = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RPJ);
      paramVarArgs.aY(3, this.CPw);
      paramVarArgs.aY(4, this.RNa);
      paramVarArgs.aY(5, this.SZH);
      if (this.sSU != null) {
        paramVarArgs.f(6, this.sSU);
      }
      if (this.SZI != null) {
        paramVarArgs.f(7, this.SZI);
      }
      paramVarArgs.aY(8, this.RKI);
      paramVarArgs.e(9, 8, this.SZJ);
      paramVarArgs.e(10, 6, this.SZK);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RPJ) + g.a.a.b.b.a.bM(3, this.CPw) + g.a.a.b.b.a.bM(4, this.RNa) + g.a.a.b.b.a.bM(5, this.SZH);
      paramInt = i;
      if (this.sSU != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.sSU);
      }
      i = paramInt;
      if (this.SZI != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SZI);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.RKI);
      int j = g.a.a.a.c(9, 8, this.SZJ);
      int k = g.a.a.a.c(10, 6, this.SZK);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SZJ.clear();
        this.SZK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bop localbop = (bop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
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
            localbop.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localbop.RPJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localbop.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localbop.RNa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localbop.SZH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localbop.sSU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localbop.SZI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localbop.RKI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boo)localObject2).parseFrom((byte[])localObject1);
            }
            localbop.SZJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localbop.SZK.add(((g.a.a.a.a)localObject1).abFh.iUw());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bop
 * JD-Core Version:    0.7.0.1
 */