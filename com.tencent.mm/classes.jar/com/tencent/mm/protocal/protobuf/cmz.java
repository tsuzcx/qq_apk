package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmz
  extends dyl
{
  public LinkedList<String> TuB;
  public String TuC;
  public LinkedList<String> TuD;
  public int TuE;
  public String Tuh;
  public String Tui;
  public String Tul;
  public int Tum;
  public String appid;
  public String fdH;
  public int scene;
  public String signature;
  public String url;
  
  public cmz()
  {
    AppMethodBeat.i(82438);
    this.TuB = new LinkedList();
    this.TuD = new LinkedList();
    AppMethodBeat.o(82438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      paramVarArgs.e(4, 1, this.TuB);
      if (this.fdH != null) {
        paramVarArgs.f(5, this.fdH);
      }
      if (this.Tuh != null) {
        paramVarArgs.f(6, this.Tuh);
      }
      if (this.signature != null) {
        paramVarArgs.f(7, this.signature);
      }
      if (this.Tui != null) {
        paramVarArgs.f(8, this.Tui);
      }
      paramVarArgs.aY(9, this.scene);
      if (this.TuC != null) {
        paramVarArgs.f(10, this.TuC);
      }
      paramVarArgs.e(11, 1, this.TuD);
      if (this.Tul != null) {
        paramVarArgs.f(12, this.Tul);
      }
      paramVarArgs.aY(13, this.TuE);
      paramVarArgs.aY(14, this.Tum);
      AppMethodBeat.o(82439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1036;
      }
    }
    label1036:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appid);
      }
      i += g.a.a.a.c(4, 1, this.TuB);
      paramInt = i;
      if (this.fdH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fdH);
      }
      i = paramInt;
      if (this.Tuh != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Tuh);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.signature);
      }
      i = paramInt;
      if (this.Tui != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Tui);
      }
      i += g.a.a.b.b.a.bM(9, this.scene);
      paramInt = i;
      if (this.TuC != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TuC);
      }
      i = paramInt + g.a.a.a.c(11, 1, this.TuD);
      paramInt = i;
      if (this.Tul != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Tul);
      }
      i = g.a.a.b.b.a.bM(13, this.TuE);
      int j = g.a.a.b.b.a.bM(14, this.Tum);
      AppMethodBeat.o(82439);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TuB.clear();
        this.TuD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cmz localcmz = (cmz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
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
            localcmz.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localcmz.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localcmz.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localcmz.TuB.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localcmz.fdH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localcmz.Tuh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localcmz.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localcmz.Tui = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localcmz.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localcmz.TuC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localcmz.TuD.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 12: 
          localcmz.Tul = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 13: 
          localcmz.TuE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82439);
          return 0;
        }
        localcmz.Tum = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmz
 * JD-Core Version:    0.7.0.1
 */