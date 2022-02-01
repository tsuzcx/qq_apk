package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class zj
  extends dyy
{
  public String OIv;
  public String Rzs;
  public djz SlG;
  public boolean SlH;
  public String scene;
  public String session_id;
  public String token;
  public int vht;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91417);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      if (this.token != null) {
        paramVarArgs.f(4, this.token);
      }
      if (this.SlG != null)
      {
        paramVarArgs.oE(5, this.SlG.computeSize());
        this.SlG.writeFields(paramVarArgs);
      }
      if (this.Rzs != null) {
        paramVarArgs.f(6, this.Rzs);
      }
      paramVarArgs.co(7, this.SlH);
      if (this.OIv != null) {
        paramVarArgs.f(8, this.OIv);
      }
      if (this.session_id != null) {
        paramVarArgs.f(9, this.session_id);
      }
      if (this.scene != null) {
        paramVarArgs.f(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.token);
      }
      paramInt = i;
      if (this.SlG != null) {
        paramInt = i + g.a.a.a.oD(5, this.SlG.computeSize());
      }
      i = paramInt;
      if (this.Rzs != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Rzs);
      }
      i += g.a.a.b.b.a.gL(7) + 1;
      paramInt = i;
      if (this.OIv != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.OIv);
      }
      i = paramInt;
      if (this.session_id != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.session_id);
      }
      paramInt = i;
      if (this.scene != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.scene);
      }
      AppMethodBeat.o(91417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zj localzj = (zj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91417);
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
            localzj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 2: 
          localzj.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91417);
          return 0;
        case 3: 
          localzj.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 4: 
          localzj.token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djz)localObject2).parseFrom((byte[])localObject1);
            }
            localzj.SlG = ((djz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91417);
          return 0;
        case 6: 
          localzj.Rzs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 7: 
          localzj.SlH = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91417);
          return 0;
        case 8: 
          localzj.OIv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91417);
          return 0;
        case 9: 
          localzj.session_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91417);
          return 0;
        }
        localzj.scene = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91417);
        return 0;
      }
      AppMethodBeat.o(91417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zj
 * JD-Core Version:    0.7.0.1
 */