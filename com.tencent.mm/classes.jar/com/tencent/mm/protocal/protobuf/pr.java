package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pr
  extends dyl
{
  public int GDA;
  public String IKl;
  public String IKm;
  public int count;
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String jUf;
  public int jUg;
  public String jUh;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jUb != null) {
        paramVarArgs.f(2, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(3, this.jUc);
      }
      if (this.jUd != null) {
        paramVarArgs.f(4, this.jUd);
      }
      if (this.jUe != null) {
        paramVarArgs.f(5, this.jUe);
      }
      if (this.jUf != null) {
        paramVarArgs.f(6, this.jUf);
      }
      paramVarArgs.aY(7, this.jUg);
      if (this.jUh != null) {
        paramVarArgs.f(8, this.jUh);
      }
      if (this.IKm != null) {
        paramVarArgs.f(9, this.IKm);
      }
      if (this.IKl != null) {
        paramVarArgs.f(10, this.IKl);
      }
      paramVarArgs.aY(11, this.type);
      if (this.value != null) {
        paramVarArgs.f(12, this.value);
      }
      paramVarArgs.aY(13, this.count);
      paramVarArgs.aY(14, this.GDA);
      AppMethodBeat.o(124452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1024;
      }
    }
    label1024:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jUb);
      }
      i = paramInt;
      if (this.jUc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUc);
      }
      paramInt = i;
      if (this.jUd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jUd);
      }
      i = paramInt;
      if (this.jUe != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jUe);
      }
      paramInt = i;
      if (this.jUf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jUf);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.jUg);
      paramInt = i;
      if (this.jUh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.jUh);
      }
      i = paramInt;
      if (this.IKm != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.IKm);
      }
      paramInt = i;
      if (this.IKl != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.IKl);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.value);
      }
      i = g.a.a.b.b.a.bM(13, this.count);
      int j = g.a.a.b.b.a.bM(14, this.GDA);
      AppMethodBeat.o(124452);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        pr localpr = (pr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124452);
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
            localpr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124452);
          return 0;
        case 2: 
          localpr.jUb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 3: 
          localpr.jUc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 4: 
          localpr.jUd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 5: 
          localpr.jUe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 6: 
          localpr.jUf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 7: 
          localpr.jUg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124452);
          return 0;
        case 8: 
          localpr.jUh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 9: 
          localpr.IKm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 10: 
          localpr.IKl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 11: 
          localpr.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124452);
          return 0;
        case 12: 
          localpr.value = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 13: 
          localpr.count = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124452);
          return 0;
        }
        localpr.GDA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124452);
        return 0;
      }
      AppMethodBeat.o(124452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pr
 * JD-Core Version:    0.7.0.1
 */