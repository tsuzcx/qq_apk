package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class auu
  extends dyl
{
  public boolean Gch;
  public aqe SDi;
  public ayv SGQ;
  public String finderUsername;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  public b xak;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230990);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      if (this.xak != null) {
        paramVarArgs.c(3, this.xak);
      }
      paramVarArgs.bm(4, this.liveId);
      if (this.finderUsername != null) {
        paramVarArgs.f(5, this.finderUsername);
      }
      paramVarArgs.aY(6, this.scene);
      paramVarArgs.bm(7, this.xbk);
      paramVarArgs.co(8, this.Gch);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(9, this.object_nonce_id);
      }
      if (this.SGQ != null)
      {
        paramVarArgs.oE(10, this.SGQ.computeSize());
        this.SGQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label912;
      }
    }
    label912:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.xak != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.xak);
      }
      i += g.a.a.b.b.a.p(4, this.liveId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.scene) + g.a.a.b.b.a.p(7, this.xbk) + (g.a.a.b.b.a.gL(8) + 1);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.object_nonce_id);
      }
      i = paramInt;
      if (this.SGQ != null) {
        i = paramInt + g.a.a.a.oD(10, this.SGQ.computeSize());
      }
      AppMethodBeat.o(230990);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auu localauu = (auu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230990);
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
            localauu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230990);
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
            localauu.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230990);
          return 0;
        case 3: 
          localauu.xak = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230990);
          return 0;
        case 4: 
          localauu.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230990);
          return 0;
        case 5: 
          localauu.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230990);
          return 0;
        case 6: 
          localauu.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230990);
          return 0;
        case 7: 
          localauu.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230990);
          return 0;
        case 8: 
          localauu.Gch = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(230990);
          return 0;
        case 9: 
          localauu.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230990);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ayv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ayv)localObject2).parseFrom((byte[])localObject1);
          }
          localauu.SGQ = ((ayv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230990);
        return 0;
      }
      AppMethodBeat.o(230990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auu
 * JD-Core Version:    0.7.0.1
 */