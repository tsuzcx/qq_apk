package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class egv
  extends dyy
{
  public int JmX;
  public int Jna;
  public String Jnb;
  public String Jnc;
  public String Jnd;
  public String Jne;
  public String Jnf;
  public boolean Jng;
  public int end_time;
  public String fUM;
  public String jEi;
  public String llI;
  public String lmL;
  public String title;
  public String tnX;
  public String tnY;
  public String tnZ;
  public int tpK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32439);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tpK);
      if (this.tnX != null) {
        paramVarArgs.f(3, this.tnX);
      }
      if (this.fUM != null) {
        paramVarArgs.f(4, this.fUM);
      }
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      if (this.tnY != null) {
        paramVarArgs.f(6, this.tnY);
      }
      if (this.tnZ != null) {
        paramVarArgs.f(7, this.tnZ);
      }
      if (this.jEi != null) {
        paramVarArgs.f(8, this.jEi);
      }
      if (this.llI != null) {
        paramVarArgs.f(9, this.llI);
      }
      if (this.lmL != null) {
        paramVarArgs.f(10, this.lmL);
      }
      paramVarArgs.aY(11, this.JmX);
      paramVarArgs.aY(12, this.Jna);
      if (this.Jnb != null) {
        paramVarArgs.f(13, this.Jnb);
      }
      if (this.Jnc != null) {
        paramVarArgs.f(14, this.Jnc);
      }
      if (this.Jnd != null) {
        paramVarArgs.f(19, this.Jnd);
      }
      if (this.Jne != null) {
        paramVarArgs.f(21, this.Jne);
      }
      paramVarArgs.aY(22, this.end_time);
      if (this.Jnf != null) {
        paramVarArgs.f(23, this.Jnf);
      }
      paramVarArgs.co(24, this.Jng);
      AppMethodBeat.o(32439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1409;
      }
    }
    label1409:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tpK);
      paramInt = i;
      if (this.tnX != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tnX);
      }
      i = paramInt;
      if (this.fUM != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.fUM);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.title);
      }
      i = paramInt;
      if (this.tnY != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.tnY);
      }
      paramInt = i;
      if (this.tnZ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.tnZ);
      }
      i = paramInt;
      if (this.jEi != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.jEi);
      }
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.llI);
      }
      i = paramInt;
      if (this.lmL != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.lmL);
      }
      i = i + g.a.a.b.b.a.bM(11, this.JmX) + g.a.a.b.b.a.bM(12, this.Jna);
      paramInt = i;
      if (this.Jnb != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Jnb);
      }
      i = paramInt;
      if (this.Jnc != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Jnc);
      }
      paramInt = i;
      if (this.Jnd != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.Jnd);
      }
      i = paramInt;
      if (this.Jne != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.Jne);
      }
      i += g.a.a.b.b.a.bM(22, this.end_time);
      paramInt = i;
      if (this.Jnf != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.Jnf);
      }
      i = g.a.a.b.b.a.gL(24);
      AppMethodBeat.o(32439);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(32439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        egv localegv = (egv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(32439);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localegv.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32439);
          return 0;
        case 2: 
          localegv.tpK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32439);
          return 0;
        case 3: 
          localegv.tnX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 4: 
          localegv.fUM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 5: 
          localegv.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 6: 
          localegv.tnY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 7: 
          localegv.tnZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 8: 
          localegv.jEi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 9: 
          localegv.llI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 10: 
          localegv.lmL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 11: 
          localegv.JmX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32439);
          return 0;
        case 12: 
          localegv.Jna = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32439);
          return 0;
        case 13: 
          localegv.Jnb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 14: 
          localegv.Jnc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 19: 
          localegv.Jnd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 21: 
          localegv.Jne = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 22: 
          localegv.end_time = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32439);
          return 0;
        case 23: 
          localegv.Jnf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32439);
          return 0;
        }
        localegv.Jng = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(32439);
        return 0;
      }
      AppMethodBeat.o(32439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egv
 * JD-Core Version:    0.7.0.1
 */