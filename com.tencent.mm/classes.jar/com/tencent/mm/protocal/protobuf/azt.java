package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class azt
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public LinkedList<String> SLr;
  public long klE;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public azt()
  {
    AppMethodBeat.i(229802);
    this.SLr = new LinkedList();
    AppMethodBeat.o(229802);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229808);
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
      paramVarArgs.e(4, 1, this.SLr);
      paramVarArgs.bm(5, this.object_id);
      paramVarArgs.bm(6, this.klE);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(7, this.object_nonce_id);
      }
      if (this.RLN != null) {
        paramVarArgs.f(8, this.RLN);
      }
      paramVarArgs.aY(9, this.scene);
      AppMethodBeat.o(229808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
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
      i = i + g.a.a.a.c(4, 1, this.SLr) + g.a.a.b.b.a.p(5, this.object_id) + g.a.a.b.b.a.p(6, this.klE);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.object_nonce_id);
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RLN);
      }
      paramInt = g.a.a.b.b.a.bM(9, this.scene);
      AppMethodBeat.o(229808);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SLr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azt localazt = (azt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229808);
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
            localazt.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229808);
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
            localazt.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229808);
          return 0;
        case 3: 
          localazt.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229808);
          return 0;
        case 4: 
          localazt.SLr.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(229808);
          return 0;
        case 5: 
          localazt.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229808);
          return 0;
        case 6: 
          localazt.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229808);
          return 0;
        case 7: 
          localazt.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229808);
          return 0;
        case 8: 
          localazt.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229808);
          return 0;
        }
        localazt.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(229808);
        return 0;
      }
      AppMethodBeat.o(229808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azt
 * JD-Core Version:    0.7.0.1
 */