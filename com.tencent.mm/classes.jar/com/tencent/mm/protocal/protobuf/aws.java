package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aws
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public int SJr;
  public String SJs;
  public long count;
  public int fSo;
  public long klE;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230339);
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
      paramVarArgs.bm(3, this.klE);
      paramVarArgs.bm(4, this.count);
      if (this.RLO != null) {
        paramVarArgs.c(5, this.RLO);
      }
      paramVarArgs.bm(6, this.object_id);
      paramVarArgs.bm(7, this.seq);
      paramVarArgs.aY(8, this.SJr);
      if (this.SJs != null) {
        paramVarArgs.f(9, this.SJs);
      }
      paramVarArgs.aY(10, this.scene);
      paramVarArgs.aY(11, this.fSo);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(12, this.object_nonce_id);
      }
      if (this.RLN != null) {
        paramVarArgs.f(13, this.RLN);
      }
      AppMethodBeat.o(230339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLM != null) {
        i = paramInt + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.klE) + g.a.a.b.b.a.p(4, this.count);
      paramInt = i;
      if (this.RLO != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.RLO);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.object_id) + g.a.a.b.b.a.p(7, this.seq) + g.a.a.b.b.a.bM(8, this.SJr);
      paramInt = i;
      if (this.SJs != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SJs);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.scene) + g.a.a.b.b.a.bM(11, this.fSo);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.object_nonce_id);
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.RLN);
      }
      AppMethodBeat.o(230339);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aws localaws = (aws)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230339);
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
            localaws.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230339);
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
            localaws.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230339);
          return 0;
        case 3: 
          localaws.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230339);
          return 0;
        case 4: 
          localaws.count = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230339);
          return 0;
        case 5: 
          localaws.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230339);
          return 0;
        case 6: 
          localaws.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230339);
          return 0;
        case 7: 
          localaws.seq = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230339);
          return 0;
        case 8: 
          localaws.SJr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230339);
          return 0;
        case 9: 
          localaws.SJs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230339);
          return 0;
        case 10: 
          localaws.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230339);
          return 0;
        case 11: 
          localaws.fSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230339);
          return 0;
        case 12: 
          localaws.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230339);
          return 0;
        }
        localaws.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(230339);
        return 0;
      }
      AppMethodBeat.o(230339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aws
 * JD-Core Version:    0.7.0.1
 */