package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azj
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public String SLk;
  public int SLl;
  public String app_id;
  public String fAo;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211230);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      if (this.SLk != null) {
        paramVarArgs.f(4, this.SLk);
      }
      if (this.fAo != null) {
        paramVarArgs.f(5, this.fAo);
      }
      if (this.app_id != null) {
        paramVarArgs.f(6, this.app_id);
      }
      paramVarArgs.aY(7, this.scene);
      paramVarArgs.aY(8, this.SLl);
      AppMethodBeat.o(211230);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label758;
      }
    }
    label758:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLN);
      }
      paramInt = i;
      if (this.SLk != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SLk);
      }
      i = paramInt;
      if (this.fAo != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fAo);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.app_id);
      }
      i = g.a.a.b.b.a.bM(7, this.scene);
      int j = g.a.a.b.b.a.bM(8, this.SLl);
      AppMethodBeat.o(211230);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211230);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azj localazj = (azj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211230);
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
            localazj.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211230);
          return 0;
        case 2: 
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
            localazj.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211230);
          return 0;
        case 3: 
          localazj.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(211230);
          return 0;
        case 4: 
          localazj.SLk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(211230);
          return 0;
        case 5: 
          localazj.fAo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(211230);
          return 0;
        case 6: 
          localazj.app_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(211230);
          return 0;
        case 7: 
          localazj.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(211230);
          return 0;
        }
        localazj.SLl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(211230);
        return 0;
      }
      AppMethodBeat.o(211230);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azj
 * JD-Core Version:    0.7.0.1
 */