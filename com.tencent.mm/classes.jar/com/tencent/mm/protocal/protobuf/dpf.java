package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpf
  extends dyl
{
  public String CRQ;
  public String CRR;
  public int SmH;
  public long TVZ;
  public int TWa;
  public String TWb;
  public int TWi;
  public int TWj;
  public int TWk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CRR != null) {
        paramVarArgs.f(2, this.CRR);
      }
      if (this.TWb != null) {
        paramVarArgs.f(3, this.TWb);
      }
      paramVarArgs.aY(4, this.SmH);
      paramVarArgs.bm(5, this.TVZ);
      paramVarArgs.aY(6, this.TWa);
      if (this.CRQ != null) {
        paramVarArgs.f(7, this.CRQ);
      }
      paramVarArgs.aY(8, this.TWj);
      paramVarArgs.aY(9, this.TWi);
      paramVarArgs.aY(10, this.TWk);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CRR);
      }
      i = paramInt;
      if (this.TWb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TWb);
      }
      i = i + g.a.a.b.b.a.bM(4, this.SmH) + g.a.a.b.b.a.p(5, this.TVZ) + g.a.a.b.b.a.bM(6, this.TWa);
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CRQ);
      }
      i = g.a.a.b.b.a.bM(8, this.TWj);
      int j = g.a.a.b.b.a.bM(9, this.TWi);
      int k = g.a.a.b.b.a.bM(10, this.TWk);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpf localdpf = (dpf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdpf.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localdpf.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localdpf.TWb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localdpf.SmH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localdpf.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localdpf.TWa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localdpf.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localdpf.TWj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localdpf.TWi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32378);
          return 0;
        }
        localdpf.TWk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpf
 * JD-Core Version:    0.7.0.1
 */