package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bkv
  extends dyl
{
  public String SVL;
  public b Sth;
  public int bPt;
  public int lAW;
  public int scene;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169068);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.lAW);
      paramVarArgs.aY(3, this.bPt);
      if (this.Sth != null) {
        paramVarArgs.c(4, this.Sth);
      }
      if (this.SVL != null) {
        paramVarArgs.f(5, this.SVL);
      }
      paramVarArgs.aY(6, this.scene);
      if (this.yjp != null)
      {
        paramVarArgs.oE(7, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lAW) + g.a.a.b.b.a.bM(3, this.bPt);
      paramInt = i;
      if (this.Sth != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Sth);
      }
      i = paramInt;
      if (this.SVL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SVL);
      }
      i += g.a.a.b.b.a.bM(6, this.scene);
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(7, this.yjp.computeSize());
      }
      AppMethodBeat.o(169068);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkv localbkv = (bkv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169068);
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
            localbkv.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169068);
          return 0;
        case 2: 
          localbkv.lAW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169068);
          return 0;
        case 3: 
          localbkv.bPt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169068);
          return 0;
        case 4: 
          localbkv.Sth = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169068);
          return 0;
        case 5: 
          localbkv.SVL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169068);
          return 0;
        case 6: 
          localbkv.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169068);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqe)localObject2).parseFrom((byte[])localObject1);
          }
          localbkv.yjp = ((aqe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      AppMethodBeat.o(169068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkv
 * JD-Core Version:    0.7.0.1
 */