package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmu
  extends dyl
{
  public int SEl;
  public String SEn;
  public int Tum;
  public String Tur;
  public String Tus;
  public int Tut;
  public String Tuu;
  public String Tuv;
  public String Tuw;
  public String appid;
  public String packageName;
  public int scene;
  public int tVq;
  public String tsk;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.Tur != null) {
        paramVarArgs.f(3, this.Tur);
      }
      paramVarArgs.aY(4, this.scene);
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      if (this.Tus != null) {
        paramVarArgs.f(6, this.Tus);
      }
      paramVarArgs.aY(7, this.tVq);
      paramVarArgs.aY(8, this.SEl);
      paramVarArgs.aY(9, this.Tut);
      if (this.Tuu != null) {
        paramVarArgs.f(10, this.Tuu);
      }
      if (this.packageName != null) {
        paramVarArgs.f(11, this.packageName);
      }
      if (this.Tuv != null) {
        paramVarArgs.f(12, this.Tuv);
      }
      paramVarArgs.aY(13, this.Tum);
      if (this.tsk != null) {
        paramVarArgs.f(14, this.tsk);
      }
      if (this.SEn != null) {
        paramVarArgs.f(15, this.SEn);
      }
      if (this.Tuw != null) {
        paramVarArgs.f(16, this.Tuw);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1128;
      }
    }
    label1128:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.Tur != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tur);
      }
      i += g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.url);
      }
      i = paramInt;
      if (this.Tus != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Tus);
      }
      i = i + g.a.a.b.b.a.bM(7, this.tVq) + g.a.a.b.b.a.bM(8, this.SEl) + g.a.a.b.b.a.bM(9, this.Tut);
      paramInt = i;
      if (this.Tuu != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Tuu);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.packageName);
      }
      paramInt = i;
      if (this.Tuv != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Tuv);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.Tum);
      paramInt = i;
      if (this.tsk != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.tsk);
      }
      i = paramInt;
      if (this.SEn != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.SEn);
      }
      paramInt = i;
      if (this.Tuw != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Tuw);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cmu localcmu = (cmu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
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
            localcmu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localcmu.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localcmu.Tur = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localcmu.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localcmu.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localcmu.Tus = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localcmu.tVq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localcmu.SEl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localcmu.Tut = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localcmu.Tuu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localcmu.packageName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 12: 
          localcmu.Tuv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 13: 
          localcmu.Tum = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123602);
          return 0;
        case 14: 
          localcmu.tsk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 15: 
          localcmu.SEn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localcmu.Tuw = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmu
 * JD-Core Version:    0.7.0.1
 */