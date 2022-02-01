package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class exg
  extends dyl
{
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eae Hnc;
  public String MD5;
  public int RJP;
  public String UserName;
  public String UxD;
  public String lVG;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.RJP);
      if (this.UxD != null) {
        paramVarArgs.f(4, this.UxD);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      paramVarArgs.aY(6, this.HmZ);
      paramVarArgs.aY(7, this.Hna);
      paramVarArgs.aY(8, this.Hnb);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(9, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.rWu);
      if (this.MD5 != null) {
        paramVarArgs.f(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label955;
      }
    }
    label955:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lVG);
      }
      i += g.a.a.b.b.a.bM(3, this.RJP);
      paramInt = i;
      if (this.UxD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UxD);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      i = i + g.a.a.b.b.a.bM(6, this.HmZ) + g.a.a.b.b.a.bM(7, this.Hna) + g.a.a.b.b.a.bM(8, this.Hnb);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(9, this.Hnc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.rWu);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exg localexg = (exg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
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
            localexg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localexg.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localexg.RJP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localexg.UxD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localexg.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localexg.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localexg.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localexg.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
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
            localexg.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localexg.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32484);
          return 0;
        }
        localexg.MD5 = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exg
 * JD-Core Version:    0.7.0.1
 */