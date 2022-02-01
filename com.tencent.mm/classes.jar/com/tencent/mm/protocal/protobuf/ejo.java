package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ejo
  extends com.tencent.mm.cd.a
{
  public int Cqs;
  public int CreateTime;
  public int DeleteFlag;
  public int IsNotRichText;
  public String Nickname;
  public String UlG;
  public int Ulm;
  public int Uln;
  public long Ulo;
  public long Ulp;
  public int Ulr;
  public LinkedList<eju> Uls;
  public int Ult;
  public String Username;
  public String lpy;
  public int rWu;
  
  public ejo()
  {
    AppMethodBeat.i(125778);
    this.Uls = new LinkedList();
    AppMethodBeat.o(125778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125779);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.f(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.f(2, this.Nickname);
      }
      paramVarArgs.aY(3, this.Cqs);
      paramVarArgs.aY(4, this.rWu);
      if (this.lpy != null) {
        paramVarArgs.f(5, this.lpy);
      }
      paramVarArgs.aY(6, this.CreateTime);
      paramVarArgs.aY(7, this.Uln);
      paramVarArgs.aY(8, this.Ulm);
      if (this.UlG != null) {
        paramVarArgs.f(9, this.UlG);
      }
      paramVarArgs.aY(10, this.IsNotRichText);
      paramVarArgs.bm(11, this.Ulo);
      paramVarArgs.bm(12, this.Ulp);
      paramVarArgs.aY(13, this.DeleteFlag);
      paramVarArgs.aY(14, this.Ulr);
      paramVarArgs.e(15, 8, this.Uls);
      paramVarArgs.aY(16, this.Ult);
      AppMethodBeat.o(125779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1028;
      }
    }
    label1028:
    for (paramInt = g.a.a.b.b.a.g(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Nickname);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Cqs) + g.a.a.b.b.a.bM(4, this.rWu);
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.CreateTime) + g.a.a.b.b.a.bM(7, this.Uln) + g.a.a.b.b.a.bM(8, this.Ulm);
      paramInt = i;
      if (this.UlG != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UlG);
      }
      i = g.a.a.b.b.a.bM(10, this.IsNotRichText);
      int j = g.a.a.b.b.a.p(11, this.Ulo);
      int k = g.a.a.b.b.a.p(12, this.Ulp);
      int m = g.a.a.b.b.a.bM(13, this.DeleteFlag);
      int n = g.a.a.b.b.a.bM(14, this.Ulr);
      int i1 = g.a.a.a.c(15, 8, this.Uls);
      int i2 = g.a.a.b.b.a.bM(16, this.Ult);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Uls.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ejo localejo = (ejo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localejo.Username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localejo.Nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localejo.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localejo.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localejo.lpy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localejo.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localejo.Uln = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localejo.Ulm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localejo.UlG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localejo.IsNotRichText = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localejo.Ulo = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localejo.Ulp = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localejo.DeleteFlag = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localejo.Ulr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eju localeju = new eju();
            if ((localObject != null) && (localObject.length > 0)) {
              localeju.parseFrom((byte[])localObject);
            }
            localejo.Uls.add(localeju);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localejo.Ult = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejo
 * JD-Core Version:    0.7.0.1
 */