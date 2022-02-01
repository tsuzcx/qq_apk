package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xz
  extends dyl
{
  public String CRQ;
  public String CRR;
  public String CqQ;
  public String CqS;
  public int RLs;
  public long RNd;
  public String RNe;
  public String ScV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9586);
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
      if (this.CRQ != null) {
        paramVarArgs.f(3, this.CRQ);
      }
      paramVarArgs.bm(4, this.RNd);
      if (this.ScV != null) {
        paramVarArgs.f(5, this.ScV);
      }
      if (this.CqS != null) {
        paramVarArgs.f(6, this.CqS);
      }
      paramVarArgs.aY(7, this.RLs);
      if (this.RNe != null) {
        paramVarArgs.f(8, this.RNe);
      }
      if (this.CqQ != null) {
        paramVarArgs.f(9, this.CqQ);
      }
      AppMethodBeat.o(9586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label759;
      }
    }
    label759:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRQ);
      }
      i += g.a.a.b.b.a.p(4, this.RNd);
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ScV);
      }
      i = paramInt;
      if (this.CqS != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.CqS);
      }
      i += g.a.a.b.b.a.bM(7, this.RLs);
      paramInt = i;
      if (this.RNe != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RNe);
      }
      i = paramInt;
      if (this.CqQ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.CqQ);
      }
      AppMethodBeat.o(9586);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(9586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        xz localxz = (xz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9586);
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
            localxz.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(9586);
          return 0;
        case 2: 
          localxz.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 3: 
          localxz.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 4: 
          localxz.RNd = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(9586);
          return 0;
        case 5: 
          localxz.ScV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 6: 
          localxz.CqS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9586);
          return 0;
        case 7: 
          localxz.RLs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(9586);
          return 0;
        case 8: 
          localxz.RNe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9586);
          return 0;
        }
        localxz.CqQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(9586);
        return 0;
      }
      AppMethodBeat.o(9586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xz
 * JD-Core Version:    0.7.0.1
 */