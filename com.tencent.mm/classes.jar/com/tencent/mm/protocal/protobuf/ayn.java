package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ayn
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public LinkedList<String> SKE;
  public long klE;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public ayn()
  {
    AppMethodBeat.i(231272);
    this.SKE = new LinkedList();
    AppMethodBeat.o(231272);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231279);
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
      if (this.RLO != null) {
        paramVarArgs.c(3, this.RLO);
      }
      paramVarArgs.bm(4, this.klE);
      paramVarArgs.bm(5, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(6, this.object_nonce_id);
      }
      paramVarArgs.aY(7, this.scene);
      if (this.RLN != null) {
        paramVarArgs.f(8, this.RLN);
      }
      paramVarArgs.e(9, 1, this.SKE);
      AppMethodBeat.o(231279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.RLO != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.RLO);
      }
      i = i + g.a.a.b.b.a.p(4, this.klE) + g.a.a.b.b.a.p(5, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.object_nonce_id);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.scene);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RLN);
      }
      i = g.a.a.a.c(9, 1, this.SKE);
      AppMethodBeat.o(231279);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SKE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231279);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ayn localayn = (ayn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231279);
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
            localayn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231279);
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
            localayn.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231279);
          return 0;
        case 3: 
          localayn.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231279);
          return 0;
        case 4: 
          localayn.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231279);
          return 0;
        case 5: 
          localayn.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231279);
          return 0;
        case 6: 
          localayn.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231279);
          return 0;
        case 7: 
          localayn.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231279);
          return 0;
        case 8: 
          localayn.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231279);
          return 0;
        }
        localayn.SKE.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(231279);
        return 0;
      }
      AppMethodBeat.o(231279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayn
 * JD-Core Version:    0.7.0.1
 */