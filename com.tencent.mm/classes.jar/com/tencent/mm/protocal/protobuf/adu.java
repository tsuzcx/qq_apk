package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class adu
  extends com.tencent.mm.cd.a
{
  public String CSe;
  public eae RIH;
  public String Sqa;
  public String Sqb;
  public int Sqc;
  public int Sqd;
  public String Sqe;
  public int Sqf;
  public String Sqg;
  public String Sqh;
  public int Sqi;
  public int Sqj;
  public LinkedList<dzp> Sqk;
  public String Sql;
  public int Sqm;
  public int Sqn;
  public int Sqo;
  public int Sqp;
  public String UserName;
  public String mVD;
  public int mVy;
  public String rWI;
  
  public adu()
  {
    AppMethodBeat.i(32174);
    this.Sqk = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.Sqa != null) {
        paramVarArgs.f(3, this.Sqa);
      }
      if (this.Sqb != null) {
        paramVarArgs.f(4, this.Sqb);
      }
      paramVarArgs.aY(5, this.mVy);
      if (this.RIH != null)
      {
        paramVarArgs.oE(6, this.RIH.computeSize());
        this.RIH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.Sqc);
      paramVarArgs.aY(8, this.Sqd);
      if (this.Sqe != null) {
        paramVarArgs.f(9, this.Sqe);
      }
      paramVarArgs.aY(10, this.Sqf);
      if (this.Sqg != null) {
        paramVarArgs.f(11, this.Sqg);
      }
      if (this.Sqh != null) {
        paramVarArgs.f(12, this.Sqh);
      }
      paramVarArgs.aY(13, this.Sqi);
      paramVarArgs.aY(14, this.Sqj);
      paramVarArgs.e(15, 8, this.Sqk);
      if (this.Sql != null) {
        paramVarArgs.f(16, this.Sql);
      }
      paramVarArgs.aY(17, this.Sqm);
      paramVarArgs.aY(18, this.Sqn);
      if (this.CSe != null) {
        paramVarArgs.f(19, this.CSe);
      }
      paramVarArgs.aY(20, this.Sqo);
      paramVarArgs.aY(21, this.Sqp);
      if (this.mVD != null) {
        paramVarArgs.f(22, this.mVD);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1550;
      }
    }
    label1550:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.Sqa != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sqa);
      }
      paramInt = i;
      if (this.Sqb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.mVy);
      paramInt = i;
      if (this.RIH != null) {
        paramInt = i + g.a.a.a.oD(6, this.RIH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Sqc) + g.a.a.b.b.a.bM(8, this.Sqd);
      paramInt = i;
      if (this.Sqe != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Sqe);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Sqf);
      paramInt = i;
      if (this.Sqg != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Sqg);
      }
      i = paramInt;
      if (this.Sqh != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.Sqh);
      }
      i = i + g.a.a.b.b.a.bM(13, this.Sqi) + g.a.a.b.b.a.bM(14, this.Sqj) + g.a.a.a.c(15, 8, this.Sqk);
      paramInt = i;
      if (this.Sql != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Sql);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.Sqm) + g.a.a.b.b.a.bM(18, this.Sqn);
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.CSe);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.Sqo) + g.a.a.b.b.a.bM(21, this.Sqp);
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.mVD);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sqk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RIH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localadu.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localadu.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localadu.Sqa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localadu.Sqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localadu.mVy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
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
            localadu.RIH = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localadu.Sqc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localadu.Sqd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localadu.Sqe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localadu.Sqf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localadu.Sqg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localadu.Sqh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localadu.Sqi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localadu.Sqj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzp)localObject2).parseFrom((byte[])localObject1);
            }
            localadu.Sqk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localadu.Sql = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localadu.Sqm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localadu.Sqn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localadu.CSe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localadu.Sqo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localadu.Sqp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32175);
          return 0;
        }
        localadu.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adu
 * JD-Core Version:    0.7.0.1
 */