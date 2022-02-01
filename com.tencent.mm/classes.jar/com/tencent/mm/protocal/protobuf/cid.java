package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cid
  extends dyl
{
  public String RDy;
  public eae Tpd;
  public String Tpe;
  public cob Tpf;
  public int Tpg;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258186);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Tpf != null)
      {
        paramVarArgs.oE(2, this.Tpf.computeSize());
        this.Tpf.writeFields(paramVarArgs);
      }
      if (this.Tpe != null) {
        paramVarArgs.f(3, this.Tpe);
      }
      if (this.Tpd != null)
      {
        paramVarArgs.oE(4, this.Tpd.computeSize());
        this.Tpd.writeFields(paramVarArgs);
      }
      if (this.RDy != null) {
        paramVarArgs.f(5, this.RDy);
      }
      paramVarArgs.aY(6, this.Tpg);
      if (this.scope != null) {
        paramVarArgs.f(7, this.scope);
      }
      AppMethodBeat.o(258186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tpf != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tpf.computeSize());
      }
      i = paramInt;
      if (this.Tpe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tpe);
      }
      paramInt = i;
      if (this.Tpd != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tpd.computeSize());
      }
      i = paramInt;
      if (this.RDy != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RDy);
      }
      i += g.a.a.b.b.a.bM(6, this.Tpg);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.scope);
      }
      AppMethodBeat.o(258186);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cid localcid = (cid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258186);
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
            localcid.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258186);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cob();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cob)localObject2).parseFrom((byte[])localObject1);
            }
            localcid.Tpf = ((cob)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258186);
          return 0;
        case 3: 
          localcid.Tpe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(258186);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localcid.Tpd = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258186);
          return 0;
        case 5: 
          localcid.RDy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(258186);
          return 0;
        case 6: 
          localcid.Tpg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(258186);
          return 0;
        }
        localcid.scope = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(258186);
        return 0;
      }
      AppMethodBeat.o(258186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cid
 * JD-Core Version:    0.7.0.1
 */