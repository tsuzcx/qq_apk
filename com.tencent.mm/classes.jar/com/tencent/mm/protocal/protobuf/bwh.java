package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwh
  extends dyl
{
  public LinkedList<abc> TfX;
  public duw Tgd;
  public boolean Tge;
  public String Tgf;
  public int type;
  
  public bwh()
  {
    AppMethodBeat.i(213174);
    this.TfX = new LinkedList();
    AppMethodBeat.o(213174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213180);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.type);
      if (this.Tgd != null)
      {
        paramVarArgs.oE(3, this.Tgd.computeSize());
        this.Tgd.writeFields(paramVarArgs);
      }
      paramVarArgs.co(4, this.Tge);
      if (this.Tgf != null) {
        paramVarArgs.f(5, this.Tgf);
      }
      paramVarArgs.e(6, 8, this.TfX);
      AppMethodBeat.o(213180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.Tgd != null) {
        paramInt = i + g.a.a.a.oD(3, this.Tgd.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.Tgf != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tgf);
      }
      i = g.a.a.a.c(6, 8, this.TfX);
      AppMethodBeat.o(213180);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(213180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwh localbwh = (bwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(213180);
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
            localbwh.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(213180);
          return 0;
        case 2: 
          localbwh.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(213180);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duw)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.Tgd = ((duw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(213180);
          return 0;
        case 4: 
          localbwh.Tge = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(213180);
          return 0;
        case 5: 
          localbwh.Tgf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(213180);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new abc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((abc)localObject2).parseFrom((byte[])localObject1);
          }
          localbwh.TfX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(213180);
        return 0;
      }
      AppMethodBeat.o(213180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwh
 * JD-Core Version:    0.7.0.1
 */