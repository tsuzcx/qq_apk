package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cnb
  extends dyl
{
  public String Tug;
  public String Tuh;
  public String Tui;
  public b Tuj;
  public String Tul;
  public int Tum;
  public String appid;
  public String fdH;
  public String signature;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82442);
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
      if (this.Tug != null) {
        paramVarArgs.f(4, this.Tug);
      }
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
      if (this.Tuj != null) {
        paramVarArgs.c(9, this.Tuj);
      }
      if (this.Tul != null) {
        paramVarArgs.f(10, this.Tul);
      }
      paramVarArgs.aY(12, this.Tum);
      AppMethodBeat.o(82442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label888;
      }
    }
    label888:
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
      paramInt = i;
      if (this.Tug != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tug);
      }
      i = paramInt;
      if (this.fdH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fdH);
      }
      paramInt = i;
      if (this.Tuh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tuh);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.signature);
      }
      paramInt = i;
      if (this.Tui != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tui);
      }
      i = paramInt;
      if (this.Tuj != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.Tuj);
      }
      paramInt = i;
      if (this.Tul != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Tul);
      }
      i = g.a.a.b.b.a.bM(12, this.Tum);
      AppMethodBeat.o(82442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82442);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cnb localcnb = (cnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(82442);
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
            localcnb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82442);
          return 0;
        case 2: 
          localcnb.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 3: 
          localcnb.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 4: 
          localcnb.Tug = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 5: 
          localcnb.fdH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 6: 
          localcnb.Tuh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 7: 
          localcnb.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 8: 
          localcnb.Tui = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        case 9: 
          localcnb.Tuj = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(82442);
          return 0;
        case 10: 
          localcnb.Tul = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82442);
          return 0;
        }
        localcnb.Tum = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(82442);
        return 0;
      }
      AppMethodBeat.o(82442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnb
 * JD-Core Version:    0.7.0.1
 */